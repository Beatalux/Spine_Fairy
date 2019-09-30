package rec.first.spine_fairy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Calendar;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends AppCompatActivity {
    Context context;
    public static final String FIRST_USER_KEY = "100";
    private AdView mAdView;

    //public SharedPreferences sharedPref=getSharedPreferences("Shared_Pref",Context.MODE_PRIVATE);
    ScreenOnReceiver screenOnReceiver;
    ImageButton set_again_btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, getString(R.string.admob_app_id));
        //배너광고
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //전면광고



        set_again_btn = findViewById(R.id.setting_agian_Button);
        context = this;
        new AlarmHATT(getApplicationContext()).Alarm();

        SharedPreferences pref = getPreferences(context.MODE_PRIVATE);
        int firstUser = pref.getInt(FIRST_USER_KEY, -1);





        //PreferenceManager.setInt(context, FIRST_USER_KEY,1);
        //int firstUser=PreferenceManager.getInt(context, FIRST_USER_KEY);
        if (firstUser == -1) {

          /* if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
        }*/
            Log.i("유저", "신규");
            saveUserIs();
            //int test=PreferenceManager.getInt(context,FIRST_USER_KEY);
            //Log.i("유저", "과연"+test);
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);


        } else {


            Log.i("유저", "기존유저");
            set_again_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent);
                }
            });

        }


        screenOnReceiver = new rec.first.spine_fairy.ScreenOnReceiver();//화면 켜짐 꺼짐 확인

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(screenOnReceiver, filter);
    }






        private void saveUserIs() {
            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(FIRST_USER_KEY, 1);
            editor.commit();
        }
    public class AlarmHATT {
        private Context context;
        public AlarmHATT(Context context) {
            this.context=context;
        }
        public void Alarm() {
            AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(MainActivity.this, BroadcastD.class);

            PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

            Calendar calendar = Calendar.getInstance();
            //알람시간 calendar에 set해주기

            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 10, 3, 00);

            if (calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, 1);
            }
            am.setRepeating(AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, sender);
            //알람 예약
        //    am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
        }
    }


}







