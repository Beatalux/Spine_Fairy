package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ScreenOnReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_SCREEN_ON)) {
            Intent intent2 = new Intent(context, MyService.class);
            context.startService(intent2);

        } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {

            Intent intent2 = new Intent(context, MyService.class);
            context.stopService(intent2);

        }
    }
}
