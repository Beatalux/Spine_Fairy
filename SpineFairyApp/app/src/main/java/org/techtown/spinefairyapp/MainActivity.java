package org.techtown.spinefairyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private FrameLayout frameLayout;
    //private Animation alphaAni;

    public String key="FREQUENCY_KEY";
    public String frequency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.container);

        RadioButton radioButton = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);

        if(radioButton.isChecked())
           frequency="자주";
      else if(radioButton2.isChecked())
           frequency="보통";
       else if(radioButton3.isChecked())
            frequency="가끔";

        SharedPreferences sharedPreferences= getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(key,frequency);
        editor.commit();
        Button button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(frequency==null)
                    Toast.makeText(getApplicationContext(),"체크해주세요",Toast.LENGTH_LONG);
                else
                {
                    //다음화면넘기기
                }
            }
        });

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.Linear);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN :
                        frameLayout.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });

    }
}