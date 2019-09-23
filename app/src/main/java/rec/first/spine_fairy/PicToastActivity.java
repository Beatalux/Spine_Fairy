package rec.first.spine_fairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class PicToastActivity extends AppCompatActivity {
    FrameLayout badposture;
    ImageView bad0=findViewById(R.id.bad0);
    ImageView bad1=(ImageView)findViewById(R.id.bad1);
    ImageView bad2=findViewById(R.id.bad2);
    ImageView bad3=findViewById(R.id.bad3);
    ImageView bad4=findViewById(R.id.bad4);
    ImageView bad5=findViewById(R.id.bad5);

    Random rnd = new Random();
    int badnum = rnd.nextInt(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_toast);

        Intent intent = getIntent();
        int move = intent.getIntExtra("badpic",0);


        LayoutInflater inflater = getLayoutInflater();

        changeView(badnum);

        View view = inflater.inflate(R.layout.activity_pic_toast,
                (ViewGroup) findViewById(R.id.linearLayout));

        Toast toast = new Toast(this);
        toast.setView(view);
        toast.show();
    }

    void changeView(int badnum) {

        badposture.removeViewAt(0) ;

        switch (badnum) {
            case 0 :
                badposture.addView(bad0) ;
                break ;
            case 1 :
                badposture.addView(bad1) ;
                break ;
            case 2 :
                badposture.addView(bad2) ;
                break ;
            case 3:
                badposture.addView(bad3) ;
                break ;
            case 4:
                badposture.addView(bad4) ;
                break ;
            case 5:
                badposture.addView(bad5) ;
                break ;


        }
    }
}