package com.example.myapplication;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrequencyFragment extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener
 {
    private FrameLayout frameLayout;
    public String frequency="";
    public final String key="FREQUENCY_KEY";
    static int check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_frequency);
        frameLayout = findViewById(R.id.container);


        RadioButton radioButton = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);
        RadioGroup radioGroup=findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);

        if(check==1)
            radioButton.setChecked(true);
        else if (check==2)
        radioButton2.setChecked(true);
        else if (check==3)
            radioButton3.setChecked(true);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (frequency == null)
                    Toast.makeText(getApplicationContext(), "체크해주세요", Toast.LENGTH_LONG);
                else {
                   finish();
                }
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.Linear);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                    }

        });

        }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.radioButton:
               check=1;
                frequency = "자주";
                PreferenceManager.setString(getApplicationContext(), key, frequency);
                break;
            case R.id.radioButton2:
                check=2;
                frequency = "보통";
                PreferenceManager.setString(getApplicationContext(), key, frequency);
                break;
            case R.id.radioButton3:
                check=3;
                frequency = "가끔";
                PreferenceManager.setString(getApplicationContext(), key, frequency);
                break;

        }
    }
}






