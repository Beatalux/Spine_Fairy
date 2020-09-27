package rec.first.spine_fairy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class BootReceiver extends BroadcastReceiver {
    public final String key="FREQUENCY_KEY";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("abc","부팅완료");
        String action = intent.getAction();
        if (action.equals("android.intent.action.BOOT_COMPLETED"))
        {String a=PreferenceManager.getString(context,key);
            new AlarmHATT3(context.getApplicationContext(),a).Alarm();
            new AlarmHATT(context.getApplicationContext()).Alarm();
        }

    }   public class AlarmHATT {
        private Context context;
        public AlarmHATT(Context context) {
            this.context=context;
        }
        public void Alarm() {
            AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, BroadcastD.class);

            PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);

            Calendar calendar = Calendar.getInstance();
            //알람시간 calendar에 set해주기

            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 9, 00, 00);

            if (calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, 1);
            }
            am.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, sender);
            //알람 예약
            //    am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
        }
    }
    public class AlarmHATT3 {
        private Context context;
        String a;
        public AlarmHATT3(Context context,String a) {
            this.context=context;
            this.a=a;
        }
        public void Alarm() {
            AlarmManager am1;
            AlarmManager am2;
            AlarmManager am3;
            PendingIntent sender;
            PendingIntent sender2;
            PendingIntent sender3;
            if(a.equals("자주"))
            {
                Log.e("abc","자주(부팅)");
                Intent intentcancel = new Intent();
                PendingIntent sendercancel
                        = PendingIntent.getBroadcast(context, 0, intentcancel, 0);
                AlarmManager manager =
                        (AlarmManager)context
                                .getSystemService(Context.ALARM_SERVICE);
                manager.cancel(sendercancel);

                am1 = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(context, Broadcast.class);
                sender = PendingIntent.getBroadcast(context, 0, intent, 0);
                Calendar calendar = Calendar.getInstance();
                //  calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
                //   am1.set (AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+1000, sender);
                am1.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis()+1000*1200, 1000*1200, sender);
                //   am1.setRepeating(AlarmManager.ELAPSED_REALTIME, triggerTime, 1000*60, sender);
            }
            else if(a.equals("보통")){
                Log.e("abc","보통(부팅)");
                Intent intentcancel = new Intent();
                PendingIntent sendercancel
                        = PendingIntent.getBroadcast(context, 0, intentcancel, 0);
                AlarmManager manager =
                        (AlarmManager)context
                                .getSystemService(Context.ALARM_SERVICE);
                manager.cancel(sendercancel);
                am2 = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent2 = new Intent(context, Broadcast.class);

                sender2 = PendingIntent.getBroadcast(context, 0, intent2, 0);
                Calendar calendar = Calendar.getInstance();
                // calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
                am2.setInexactRepeating (AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis()+1000*2100, 1000*2100, sender2);
            }

            else if(a.equals("가끔")){
                Log.e("abc","가끔(부팅)");
                Intent intentcancel = new Intent();
                PendingIntent sendercancel
                        = PendingIntent.getBroadcast(context, 0, intentcancel, 0);
                AlarmManager manager =
                        (AlarmManager)context
                                .getSystemService(Context.ALARM_SERVICE);
                manager.cancel(sendercancel);
                am3 = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent intent3 = new Intent(context, Broadcast.class);

                sender3 = PendingIntent.getBroadcast(context, 0, intent3, 0);
                Calendar calendar = Calendar.getInstance();
                //calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
                am3.setInexactRepeating (AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis()+1000*3000, 1000*3000, sender3);
            }

        }
}}
