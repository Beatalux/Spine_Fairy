package rec.first.spine_fairy;

import android.app.NotificationChannel;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

import rec.first.spine_fairy.CommonToast;
import rec.first.spine_fairy.MainActivity;
import rec.first.spine_fairy.ServiceThread;

public class MyService extends Service{


    NotificationManager Notifi_M;
    ServiceThread thread;
    Notification Notifi ;

    NotificationCompat.Builder mBuilder;
    public Intent intent1,intent2;
    public PendingIntent pintent1,pintent2 ;
    public RemoteViews contentView;


    final String strId =  "my_channel_02";
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
        //thread = new ServiceThread(handler);//serviceThrad 클래스
        thread.isRun=true;
        thread.start();

        return START_STICKY;
    }

    //서비스가 종료될 때 할 작업

    public void onDestroy() {
        Log.e("abc","서비스 종료");
        thread.isRun=false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            stopForeground(true);
        }
        //thread.stopForever();
        //ScreenOnReceiver screenOnReceiver=new ScreenOnReceiver();
        //getApplicationContext().unregisterReceiver(screenOnReceiver);
        thread = null;//쓰레기 값을 만들어서 빠르게 회수하라고 null을 넣어줌.

    }




    class myServiceHandler extends Handler {//여기가 계속 토스트 뜨는 곳


        @Override
        public void handleMessage(android.os.Message msg) {
            Intent intent = new Intent(MyService.this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(MyService.this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);

            //토스트 띄우기
            int a= (int) (Math.random()*4+1);
            if(a%4==0||a%4==1||a%4==2) {
                Toast.makeText(MyService.this, "척추 펴세요!!!", Toast.LENGTH_LONG).show();
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v.vibrate(500);
                }
            }


            else if(a%4==3){
                int b=(int)(Math.random()*6);


                contentView = new RemoteViews(getPackageName(), R.layout.notify);
                if(b==0) contentView.setImageViewResource(R.id.imageView2,R.drawable.bad0);
                else if(b==1)contentView.setImageViewResource(R.id.imageView2,R.drawable.bad1);
                else if(b==2)contentView.setImageViewResource(R.id.imageView2,R.drawable.bad2);
                else if(b==3)contentView.setImageViewResource(R.id.imageView2,R.drawable.bad3);
                else if(b==4)contentView.setImageViewResource(R.id.imageView2,R.drawable.bad4);
                else if(b==5)contentView.setImageViewResource(R.id.imageView2,R.drawable.bad5);



                NotificationCompat.Builder builder = null;
                NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)

                {
                    String channelId = "default_channel_id";
                    String channelDescription = "Default Channel";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelId);
                    if (notificationChannel == null) {
                        int importance = NotificationManager.IMPORTANCE_HIGH;
                        notificationChannel = new NotificationChannel(channelId, channelDescription, importance);
                        notificationChannel.setLightColor(Color.GREEN);
                        notificationChannel.enableVibration(true);
                        notificationManager.createNotificationChannel(notificationChannel);
                        builder = new NotificationCompat.Builder(getApplicationContext(), channelId);
                        builder.setSmallIcon(R.drawable.logo).setContent(contentView);
                    }

                    Notification n=builder.build();
                    n.flags = Notification.FLAG_AUTO_CANCEL;
                    notificationManager.notify(1, builder.build());
                } else {
                    Notification.Builder builder2 = new Notification.Builder(getApplicationContext());
                    builder2.setSmallIcon(R.drawable.logo).setContent(contentView)
                            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setAutoCancel(true);
                    Notification notification = builder2.build();
                    notification.flags = Notification.FLAG_AUTO_CANCEL;

                    notificationManager.notify(1, notification);


                }




            }

    }

        }



}
