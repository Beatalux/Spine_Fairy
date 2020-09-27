package rec.first.spine_fairy;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.Random;

public class Broadcast extends BroadcastReceiver {
    final String strId =  "my_channel_01";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("abc","Toast");
   //     Toast.makeText(context,"sdf",Toast.LENGTH_LONG).show();
        Random rnd = new Random();
        int num = rnd.nextInt(2);

        if (num == 0) {
        int badnum = rnd.nextInt(6);

        LayoutInflater mInflater = LayoutInflater.from(context);
        View myView;

        Toast toast=new Toast(context);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);

        switch(badnum) {
            case 0:
                myView = mInflater.inflate(R.layout.toast_bad0, null);
                toast.setView(myView);
                break;
            case 1:
                myView = mInflater.inflate(R.layout.toast_bad1, null);
                toast.setView(myView);
                break;
            case 2:
                myView = mInflater.inflate(R.layout.toast_bad2, null);
                toast.setView(myView);
                break;
            case 3:
                myView = mInflater.inflate(R.layout.toast_bad3, null);
                toast.setView(myView);
                break;
            case 4:
                myView = mInflater.inflate(R.layout.toast_bad4, null);
                toast.setView(myView);
                break;
            case 5:
                myView = mInflater.inflate(R.layout.toast_bad5, null);
                toast.setView(myView);
                break;
        }

        toast.show();
        }
        else
            Toast.makeText(context,"척추펴세요",Toast.LENGTH_SHORT).show();
    }


}
