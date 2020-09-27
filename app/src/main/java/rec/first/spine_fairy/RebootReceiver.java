package rec.first.spine_fairy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RebootReceiver extends BroadcastReceiver {
    public final String key="FREQUENCY_KEY";
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1= new Intent(context,LoadingActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
