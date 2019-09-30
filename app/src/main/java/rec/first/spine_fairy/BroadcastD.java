package rec.first.spine_fairy;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class BroadcastD extends BroadcastReceiver {
    final String strId =  "my_channel_01";
    @Override
    public void onReceive(Context context, Intent intent) {//알람 시간이 되었을때 onReceive를 호출함
        //NotificationManager 안드로이드 상태바에 메세지를 던지기위한 서비스 불러오고
        Log.i("abc","hkkjhk");
        String [] mentzip={"매년 10월 16일은 세계보건기구에서 정한 “척추의 날”이다.",
                "일자목 진료비로만 연평균 4412억이 나가고 있다. (출처: 국민건강보험공단 2018년 기준)"
                ,"척추질환 환자가 최근 5년만에 약 90만명 증가했다. (출처: 건강보험심사평가원 의료통계정보 2018년 기준)"
                ,"일자목 증후군 환자의 61%는 10∼30대에 집중되어 있다. (출처: 건강보험심사평가원 의료통계정보 2016 기준)",
                "척추의 퇴행은 노년기가 아니라 20대 청년기에 시작된다."
                ,"술은 뼈에서 칼슘을 빠져나가게 하여 척추 건강에 치명적이다."
                , "담배의 일산화탄소는 척추 혈액순환을 방해해 뼈로 가는 무기질 흡수를 막아 척추 퇴행을 촉진한다."
                , "척추질환을 앓는 국내 환자 수는 약 1260만명이다. (출처: 건강보험심사평가원 2014년 기준)",
                "척추질환은 조기에 발견하면 수술 없이도 치료가 가능하다. 그러나 뒤늦게 발견하면 수술을 받아도 후유증이 남거나 재수술을 해야 할 확률이 높아진다.",
                "대부분의 척추질환은 초기 증상이 거의 없다. 꾸준한 정기 검진이 필요하다.",
                "스마트폰을 사용할 때에는 기기를 정면 기준 눈 앞에 오도록 올려서 사용하는 것이 좋다.",
                "컴퓨터를 사용할 때에는 앉은 자세에서 눈이 모니터의 중앙에 오도록 모니터 높이를 조정하는 것이 좋다.",
                "스마트폰 보급률이 증가하면서 일자목 환자도 그에 비례해 증가하고 있다.",
                "턱을 괴거나 다리를 꼬는 습관은 척추 측만증의 결정적 원인이 된다."
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            final String strTitle = context.getString(R.string.app_name);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel channel = notificationManager.getNotificationChannel(strId);
            if (channel == null) {
                channel = new NotificationChannel(strId, strTitle, NotificationManager.IMPORTANCE_HIGH);
                notificationManager.createNotificationChannel(channel);
            }
            Notification notification = new NotificationCompat.Builder(context, strId)
                    .setContentTitle("New Message")
                    .setContentText("You've received new messages.")
                    .setSmallIcon(R.drawable.logo)
                    .setChannelId(strId)
                    .build();
            notificationManager.notify(1,notification);
        }


        else {
            NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
            Notification.Builder builder = new Notification.Builder(context);
            String ment = mentzip[(int) (Math.random() * 14)];
            builder.setSmallIcon(R.drawable.logo).setTicker("HETT").setWhen(System.currentTimeMillis())
                    .setNumber(1).setContentTitle("척추요정이 출몰했습니다").setContentText(ment)
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingIntent).setAutoCancel(true);

            notificationmanager.notify(1, builder.build());
        }
    }
}
