package rec.first.spine_fairy;

import android.os.Handler;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import rec.first.spine_fairy.ServiceThread;

public class MyService extends Service{



    //NotificationManager Notifi_M;
    ServiceThread thread;
    Notification Notifi ;
    Context context;


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Notifi_M = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myServiceHandler handler = new myServiceHandler();//54줄 콜
        thread = new ServiceThread(handler);//serviceThrad 클래스
        thread.isRun=true;

        thread.start();
        return START_STICKY;
    }

    //서비스가 종료될 때 할 작업

    public void onDestroy() {
        Log.e("abc","서비스 종료");
        thread.isRun=false;
        //thread.stopForever();
        //ScreenOnReceiver screenOnReceiver=new ScreenOnReceiver();
        //getApplicationContext().unregisterReceiver(screenOnReceiver);
        thread = null;//쓰레기 값을 만들어서 빠르게 회수하라고 null을 넣어줌.

    }



    class myServiceHandler extends Handler {//여기가 계속 토스트 뜨는 곳
        @Override
        public void handleMessage(android.os.Message msg) {
//            Intent intent = new Intent(MyService.this, MainActivity.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(MyService.this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//

            //int divide=PreferenceManager.getInt(context, "Data");

            //토스트 띄우기
            //if(divide/4==0||a/4==1)
            Toast.makeText(MyService.this, "척추 펴세요!!!", Toast.LENGTH_LONG).show();
            /*else if(a/4==2){
                Intent intent=new Intent(getApplicationContext(), PicToastActivity.class);
                startActivity(intent);
            }
            else
            {Intent intent=new Intent(getApplicationContext(),PopupActivityforMove.class);
                startActivity(intent);}*/

        }
    }


}
