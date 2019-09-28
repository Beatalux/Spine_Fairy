package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Context context;
    public static final String FIRST_USER_KEY="100";
    ScreenOnReceiver screenOnReceiver;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        PreferenceManager.setInt(context,FIRST_USER_KEY,1);//원래 이게 없어야 함.
        int firstUser=PreferenceManager.getInt(context, FIRST_USER_KEY);
        if(firstUser==-1){
            Log.d("유저", "신규");
            Intent intent = new Intent(MainActivity.this,FrequencyFragment.class);
            startActivity(intent);
            PreferenceManager.setInt(context, FIRST_USER_KEY,1);
        }
        else {
            Log.d("유저","기존유저");

            ImageView imageView= findViewById(R.id.imageView2);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,FrequencyFragment.class);
                    startActivity(intent);

                }
            });
        }

        screenOnReceiver = new ScreenOnReceiver();//화면 켜짐 꺼짐 확인
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(screenOnReceiver, filter);
    }

}
