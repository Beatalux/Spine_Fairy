package rec.first.spine_fairy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends AppCompatActivity {
    Context context;
    public static final String FIRST_USER_KEY="100";
    //public SharedPreferences sharedPref=getSharedPreferences("Shared_Pref",Context.MODE_PRIVATE);
    ScreenOnReceiver screenOnReceiver;
    Button btnStart,btnEnd;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;


        PreferenceManager.setInt(context, FIRST_USER_KEY,-1);
        int firstUser=PreferenceManager.getInt(context, FIRST_USER_KEY);
        if(firstUser==-1){
            Log.d("유저", "신규");
            Intent intent = new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
            PreferenceManager.setInt(context, FIRST_USER_KEY,1);
        }
        else {
            Log.d("유저","기존유저");
            callMove();
        }


        /*Fragment[] arrFragments=new Fragment[3];//처음 앱 깔았을 때 설정위해
        arrFragments[0]=new tutorialFragment();
        arrFragments[0]=new FrequencyFragment();
        ViewPager viewPager=(ViewPager)findViewById(R.id.setting_view);
        SettingPageAdapter adapter=new SettingPageAdapter(getSupportFragmentManager(),BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,arrFragments);
        viewPager.setAdapter(adapter);//여기까지 설정 viewPager*/


        //나중에 없앨껀데 버튼 눌렀을 때
        btnStart = (Button)findViewById(R.id.btn_start);
        btnEnd = (Button)findViewById(R.id.btn_end);

        btnStart.setOnClickListener(new View.OnClickListener() {//처음 버튼 눌렀을 때만 뜸
            @Override
            public void onClick(View v) {//처음시작버튼
                Toast.makeText(getApplicationContext(),"Service 시작",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,MyService.class);
                startService(intent);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {//마지막 종료 버튼 눌렀을때만 뜸
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Service 끝",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });





        screenOnReceiver = new rec.first.spine_fairy.ScreenOnReceiver();//화면 켜짐 꺼짐 확인

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(screenOnReceiver, filter);
    }


    public void callMove() {
        PopupActivityforMove dialog=new PopupActivityforMove();
        dialog.getWindow().setGravity(Gravity.TOP);
        Intent intent = new Intent(this, PopupActivityforMove.class);
        intent.putExtra("move", 0);
        startActivityForResult(intent, 1);
    }


}
