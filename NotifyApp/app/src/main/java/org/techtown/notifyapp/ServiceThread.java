package org.techtown.notifyapp;
import android.os.Handler;

public class ServiceThread extends Thread {
    Handler handler;
    boolean isRun = true;

    public ServiceThread(Handler handler){
        this.handler = handler;
    }

//    public void stopForever(){
//        synchronized (this) {
//            this.isRun = false;
//        }
//    }

    public void run(){
        //반복적으로 수행할 작업을 한다.
        while(isRun){

            int a=1; //1- 조금(10-19), 2- 보통(20-29), 3- 많이(30-39)
            int time;
            if(a==1) {
                time =(int)(Math.random() * 10 + 10);
            }
            else if(a==2){
                time =(int)(Math.random() * 10 + 20);
            }
            else
                time =(int)(Math.random() * 10 + 30);


            try{
                Thread.sleep(time*60*1000);
               // Thread.sleep(1000);
                handler.sendEmptyMessage(0);//쓰레드에 있는 핸들러에게 메세지를 보냄

            }catch (Exception e) {}
        }
    }


}
