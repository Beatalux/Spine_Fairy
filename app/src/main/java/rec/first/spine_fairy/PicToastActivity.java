package rec.first.spine_fairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class PicToastActivity extends AppCompatActivity {
    ImageView iv1,iv2;

    //int[]img={R.drawable.bad0, R.drawable.bad1, R.drawable.bad2, R.drawable.bad3, R.drawable.bad4, R.drawable.bad5};


    Context context;
    private int mScreenWidth,mScreenHeight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pic_toast);

        context=getApplicationContext();



        Log.i("인텐트","받음");

        //Display display=((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        //mScreenWidth=display.getWidth();



        Random rnd = new Random();
        int badnum = rnd.nextInt(5);


        Toast toast = new Toast(context);

        switch(badnum){
            case 0:toast.setView(getLayoutInflater().inflate(R.layout.activity_pic_toast,null));
                break;

            case 1:toast.setView(getLayoutInflater().inflate(R.layout.activity_pic_toast1,null));
                break;
            case 2:toast.setView(getLayoutInflater().inflate(R.layout.activity_pic_toast2,null));
                break;
            case 3:toast.setView(getLayoutInflater().inflate(R.layout.activity_pic_toast3,null));
                break;
            case 4:toast.setView(getLayoutInflater().inflate(R.layout.activity_pic_toast4,null));
                break;
            case 5:toast.setView(getLayoutInflater().inflate(R.layout.activity_pic_toast5,null));
                break;

        }

        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }



}