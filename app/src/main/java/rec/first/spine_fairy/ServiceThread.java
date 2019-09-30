package rec.first.spine_fairy;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import java.util.Calendar;

public class ServiceThread extends Thread {

    private long curTime;
    NotificationManager Notifi_M;
    Notification Notifi ;
    Handler handler;
    boolean isRun = true;
    public final String key="FREQUENCY_KEY";
    Context mcontext;


    public ServiceThread(Context context,Handler handler){
        this.handler = handler;
        mcontext = context;

    }

//    public void stopForever(){
//        synchronized (this) {
//            this.isRun = false;
//        }
//    }

    public void run(){
        //반복적으로 수행할 작업을 한다.
        while(isRun){

            //int a=1; //1- 조금(10-19), 2- 보통(20-29), 3- 많이(30-39)
            String a=PreferenceManager.getString(mcontext,key);
            int time;
            if(a=="자주") {
                time =(int)(Math.random() * 10 + 10);
                PreferenceManager.setInt(mcontext,"Data",time);
            }
            else if(a=="보통"){
                time =(int)(Math.random() * 10 + 20);
                PreferenceManager.setInt(mcontext,"Data",time);
            }
            else
            {time =(int)(Math.random() * 10 + 30);
            PreferenceManager.setInt(mcontext,"Data",time);}



            try{
                Thread.sleep(5000);//시간 정하기
               //Thread.sleep(5000);
                handler.sendEmptyMessage(0);//쓰레드에 있는 핸들러에게 메세지를 보냄

            }catch (Exception e) {}
        }
    }


}
