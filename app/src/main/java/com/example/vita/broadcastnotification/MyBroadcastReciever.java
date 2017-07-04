package com.example.vita.broadcastnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * Created by Vita on 2017/7/3.
 */

public class MyBroadcastReciever extends BroadcastReceiver {
    private static  final  String TAG = "########";
    private NotificationManager notifyMgr;
    private Notification.Builder builder1;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "intent "+intent);
        sendNotification(context);

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void  sendNotification(Context context){
        notifyMgr = (NotificationManager)  context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder1 = new Notification.Builder(context);

        builder1.setSmallIcon(R.mipmap.ic_launcher);
        builder1.setContentTitle("提示");
        builder1.setContentText("天使天使天使");
        builder1.setSubText("hahah");
        builder1.setTicker("notification来了");
        builder1.setAutoCancel(false);

        Intent mIntent = new Intent(context,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context,1, mIntent,PendingIntent.FLAG_ONE_SHOT);
        Notification notify1=builder1.build();

        notifyMgr.notify(1,notify1);
    }

}
