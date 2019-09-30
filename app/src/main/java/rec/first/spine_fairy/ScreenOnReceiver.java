package rec.first.spine_fairy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

public class ScreenOnReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_SCREEN_ON)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(new Intent(context, MyService.class));
            } else {
                context.startService(new Intent(context, MyService.class));
            }

        } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {

            // Toast.makeText(context,"화면꺼짐",Toast.LENGTH_LONG).show();
            Intent intent2 = new Intent(context, rec.first.spine_fairy.MyService.class);
            context.stopService(intent2);

        }
    }}
