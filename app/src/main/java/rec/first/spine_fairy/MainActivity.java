package rec.first.spine_fairy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.MobileAds;

import java.util.Calendar;

public  class MainActivity extends AppCompatActivity {
    Context context;
    public static final String FIRST_USER_KEY = "100";
    private AdView mAdView;
    public final String key="FREQUENCY_KEY";

    //public SharedPreferences sharedPref=getSharedPreferences("Shared_Pref",Context.MODE_PRIVATE);

    Button set_again_btn;

    @Override
    public void onBackPressed() {
   //     Toast.makeText(this, "Back button pressed.", Toast.LENGTH_SHORT).show();
      //  super.onBackPressed();
        final String appPackageName = getApplicationContext().getPackageName(); // getPackageName() from Context or Activity object
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("척추요정을 응원해주세요")
                .setMessage("리뷰 부탁드립니다!")
                .setNegativeButton("리뷰하기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                        try {

                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                })   .setNeutralButton("다음에하기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                        System.exit(0);


                    }
                }).show(); // 팝업창 보여줌

    }

    @Override
    protected void onResume() {
        super.onResume();
        String a=PreferenceManager.getString(this,key);
        new AlarmHATT2(this,a).Alarm();
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String a=PreferenceManager.getString(this,key);
//        new AlarmHATT2(this,a);
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        //배너광고
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //전면광고


        set_again_btn = findViewById(R.id.setting_agian_Button);
        context = this;
        new AlarmHATT(getApplicationContext()).Alarm();
        set_again_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
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
       /*     set_again_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent);
                }
            });
*/
        }



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

            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 9, 00, 00);

            if (calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, 1);
            }
            am.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, sender);
            //            //알람 예약
        //    am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
        }
    }
    public class AlarmHATT2 {
        private Context context;
        String a;
        public AlarmHATT2(Context context,String a) {
            this.context=context;
            this.a=a;
        }
        public void Alarm() {
            AlarmManager am1;
            AlarmManager am2;
            AlarmManager am3;
            PendingIntent sender;
            PendingIntent sender2;
            PendingIntent sender3;
            if(a.equals("자주"))
            {
                Log.e("abc","자주");
                Intent intentcancel = new Intent();
                PendingIntent sendercancel
                        = PendingIntent.getBroadcast(context, 0, intentcancel, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager manager =
                        (AlarmManager)context
                                .getSystemService(Context.ALARM_SERVICE);
                manager.cancel(sendercancel);

                am1 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(MainActivity.this, Broadcast.class);
                sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
                Calendar calendar = Calendar.getInstance();
                //  calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
             //   am1.set (AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+1000, sender);
                am1.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis()+1000*1200, 1000*1200, sender);
                //   am1.setRepeating(AlarmManager.ELAPSED_REALTIME, triggerTime, 1000*60, sender);
            }
            else if(a.equals("보통")){
                Log.e("abc","보통");
                Intent intentcancel = new Intent();
                PendingIntent sendercancel
                        = PendingIntent.getBroadcast(context, 0, intentcancel, 0);
                AlarmManager manager =
                        (AlarmManager)context
                                .getSystemService(Context.ALARM_SERVICE);
                manager.cancel(sendercancel);
                am2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent2 = new Intent(MainActivity.this, Broadcast.class);

                sender2 = PendingIntent.getBroadcast(MainActivity.this, 0, intent2, PendingIntent.FLAG_CANCEL_CURRENT);
                Calendar calendar = Calendar.getInstance();
                // calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
                am2.setInexactRepeating (AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis()+1000*2100, 1000*2100, sender2);
            }

            else if(a.equals("가끔")){
                Log.e("abc","가끔");
                Intent intentcancel = new Intent();
                PendingIntent sendercancel
                        = PendingIntent.getBroadcast(context, 0, intentcancel, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager manager =
                        (AlarmManager)context
                                .getSystemService(Context.ALARM_SERVICE);
                manager.cancel(sendercancel);
                am3 = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent3 = new Intent(context, Broadcast.class);

                sender3 = PendingIntent.getBroadcast(context, 0, intent3, 0);
                Calendar calendar = Calendar.getInstance();
                //calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
                am3.setInexactRepeating (AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis()+1000*3000, 1000*3000, sender3);
            }
            //알람 예약
            //    am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
        }
    }
}







