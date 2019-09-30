package rec.first.spine_fairy;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CommonToast extends Toast {
    Context mContext;//context 관련해서 오류나는듯..

    public CommonToast(Context context) {
    super(context);
    mContext = context; }

    public void showToast(String body, int duration){

    LayoutInflater inflater;
    View v;
    if(false){
        Activity act = (Activity)mContext; inflater = act.getLayoutInflater();
    v = inflater.inflate(R.layout.activity_pic_toast, null);
    }
    else{ // same
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_pic_toast1, null); }
   // TextView text = (TextView) v.findViewById(R.id.text);
    //text.setText(body);
    show(this,v,duration); }

    private void show(Toast toast, View v, int duration){
    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    toast.setDuration(duration);
    toast.setView(v);
    toast.show(); }
}

