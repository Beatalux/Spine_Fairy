package rec.first.spine_fairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    //빈도에 따라 호출, 초기설정에서 받아옴

    //int frequency;

    //if(frequency==0){}


    public void callMove(View view) {
        PopupActivityforMove dialog=new PopupActivityforMove();
        dialog.getWindow().setGravity(Gravity.TOP);
        Intent intent = new Intent(this, PopupActivityforMove.class);
        intent.putExtra("move", 0);
        startActivityForResult(intent, 1);


    }


}
