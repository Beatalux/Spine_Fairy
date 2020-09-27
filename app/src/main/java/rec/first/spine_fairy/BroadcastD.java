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
                "일자목 진료비로만 연평균 4412억이 나가고 있다. \n(출처: 국민건강보험공단 2018년 기준)"
                ,"척추질환 환자가 최근 5년만에 약 90만명 증가했다. \n(출처: 건강보험심사평가원 의료통계정보 2018년 기준)"
                ,"일자목 증후군 환자의 61%는 10∼30대에 집중되어 있다. \n(출처: 건강보험심사평가원 의료통계정보 2016 기준)",
                "척추의 퇴행은 노년기가 아니라 20대 청년기에 시작된다."
                ,"술은 뼈에서 칼슘을 빠져나가게 하여 척추 건강에 치명적이다."
                , "담배의 일산화탄소는 척추 혈액순환을 방해해 뼈로 가는 무기질 흡수를 막아 척추 퇴행을 촉진한다."
                , "척추질환을 앓는 국내 환자 수는 약 1260만명이다. \n(출처: 건강보험심사평가원 2014년 기준)",
                "척추질환은 조기에 발견하면 수술 없이도 치료가 가능하다. 그러나 뒤늦게 발견하면 수술을 받아도 후유증이 남거나 재수술을 해야 할 확률이 높아진다.",
                "대부분의 척추질환은 초기 증상이 거의 없다. 꾸준한 정기 검진이 필요하다.",
                "스마트폰을 사용할 때에는 기기를 정면 기준 눈 앞에 오도록 올려서 사용하는 것이 좋다.",
                "컴퓨터를 사용할 때에는 앉은 자세에서 눈이 모니터의 중앙에 오도록 모니터 높이를 조정하는 것이 좋다.",
                "스마트폰 보급률이 증가하면서 일자목 환자도 그에 비례해 증가하고 있다.",
                "턱을 괴거나 다리를 꼬는 습관은 척추 측만증의 결정적 원인이 된다.","컴퓨터 모니터가 시선보다 아래에 놓이지 않도록 책 등을 괴어 놓아라.",
"스마트폰 이용 시 눈높이 보다 약간 낮게 들고 보고, 이용 시간은 1시간 이내로 해라",
"엎드리는 습관은 경추 관절을 변형 시키기 때문에 엎드려 책을 보거나 자는 습관을 고쳐라.",
"의자 등받이에 쿠션을 대어 등과 의자가 밀착되도록 앉아라.",
"양손을 등 뒤에서 깍지를 끼고 쭉 펴주는 뒤 기지개를 자주 해라."
        };
        String ment = mentzip[(int) (Math.random() * 19)];
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            final String strTitle = context.getString(R.string.app_name);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel channel = notificationManager.getNotificationChannel(strId);
            if (channel == null) {
                channel = new NotificationChannel(strId, strTitle, NotificationManager.IMPORTANCE_HIGH);
                notificationManager.createNotificationChannel(channel);
            }
            Notification notification = new NotificationCompat.Builder(context, strId)
                   // .setContentTitle("척추요정")
                    .setContentText(ment)
                    .setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle("오늘의 척추이야기"))
                    .setSmallIcon(R.drawable.appicon)
                    .setChannelId(strId)
                    .build();
            notificationManager.notify(1,notification);
        }


        else {
            NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
            Notification.Builder builder = new Notification.Builder(context);

            builder.setSmallIcon(R.drawable.appicon).setTicker("HETT").setWhen(System.currentTimeMillis())
                    .setNumber(1).setContentTitle("척추요정").setContentText(ment).setStyle(new Notification.BigTextStyle().setBigContentTitle(ment))
                    .setPriority(Notification.PRIORITY_MAX)
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingIntent).setAutoCancel(true);
            notificationmanager.notify(1, builder.build());
        }
    }
}
