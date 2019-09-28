package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class MyService extends Service{


    NotificationManager Notifi_M;
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
        Notifi_M = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myServiceHandler handler = new myServiceHandler();//54줄 콜
        thread = new ServiceThread(this,handler);
        thread.isRun=true;
        thread.start();
        return START_STICKY;
    }

    //서비스가 종료될 때 할 작업

    public void onDestroy() {
        Log.e("abc","서비스 종료");
        thread.isRun=false;
        thread = null;//쓰레기 값을 만들어서 빠르게 회수하라고 null을 넣어줌.

    }



    class myServiceHandler extends Handler {//여기가 계속 토스트 뜨는 곳

        @Override
        public void handleMessage(android.os.Message msg) {
            Intent intent = new Intent(MyService.this, MainActivity.class);
        //    PendingIntent pendingIntent = PendingIntent.getActivity(MyService.this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
////
//            Notifi = new Notification.Builder(getApplicationContext())
//                    .setContentTitle("Content Title")
//                    .setContentText("Content Text")
//                    .setSmallIcon(R.drawable.logo)
//                    .setTicker("알림!!!")
//                    .setContentIntent(pendingIntent)
//                    .build();
//
//            //소리추가
//            Notifi.defaults = Notification.DEFAULT_SOUND;
//
//            //알림 소리를 한번만 내도록
//            Notifi.flags = Notification.FLAG_ONLY_ALERT_ONCE;
//
//            //확인하면 자동으로 알림이 제거 되도록
//            Notifi.flags = Notification.FLAG_AUTO_CANCEL;
//
//
//            Notifi_M.notify( 777 , Notifi);




            Toast.makeText(MyService.this, "척추 펴세요!!!", Toast.LENGTH_LONG).show();


    }

        }



}
