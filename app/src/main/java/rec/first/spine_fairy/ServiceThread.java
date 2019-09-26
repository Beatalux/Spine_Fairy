package rec.first.spine_fairy;
import android.content.Context;
import android.os.Handler;

public class ServiceThread extends Thread {






    Handler handler;
    boolean isRun = true;
    public final String key="FREQUENCY_KEY";
    Context context;


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

            //int a=1; //1- 조금(10-19), 2- 보통(20-29), 3- 많이(30-39)
            String a=PreferenceManager.getString(context,key);
            int time;
            if(a=="자주") {
                time =(int)(Math.random() * 10 + 10);
                PreferenceManager.setInt(context,"Data",time);
            }
            else if(a=="보통"){
                time =(int)(Math.random() * 10 + 20);
                PreferenceManager.setInt(context,"Data",time);
            }
            else
            {time =(int)(Math.random() * 10 + 30);
            PreferenceManager.setInt(context,"Data",time);}



            try{
                Thread.sleep(time*60*1000);//시간 정하기
               //Thread.sleep(5000);
                handler.sendEmptyMessage(0);//쓰레드에 있는 핸들러에게 메세지를 보냄

            }catch (Exception e) {}
        }
    }


}
