package rec.first.spine_fairy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import static android.widget.Toast.LENGTH_SHORT;
import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class SettingActivity extends AppCompatActivity {
    //private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        Intent intent=getIntent();
        Log.i("인텐트", "받음");



        Fragment[] arrFragments = new Fragment[1];//처음 앱 깔았을 때 설정위해
        arrFragments[0] = new FrequencyFragment();
        ViewPager viewPager = (ViewPager) findViewById(R.id.setting_view);
        SettingPageAdapter adapter = new SettingPageAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, arrFragments);
        viewPager.setAdapter(adapter);//여기까지 설정 viewPager

    }
}



