package com.example.vita.broadcastnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Vita on 2017/7/3.
 */

public class MyBroadcastReciever extends BroadcastReceiver {
    private static  final  String TAG = "########";
    private NotificationManager notifyMgr;
    private NotificationCompat.Builder builder1;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "intent "+intent);
        String text = intent.getStringExtra("name");

        sendNotification(context,text);


    }


//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void  sendNotification(Context context,String text){
        notifyMgr = (NotificationManager)  context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder1 = new NotificationCompat.Builder(context);

        builder1.setSmallIcon(R.mipmap.ic_launcher);
        builder1.setContentTitle("提示");
        builder1.setContentText("enjoy summer days");
        builder1.setSubText("notification");
        builder1.setTicker(text);
        builder1.setAutoCancel(false);

        Intent mIntent = new Intent(context,MainActivity.class);
        Log.d(TAG, "contexd: "+context+"；Otheractivity.class："+OtherActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context,0, mIntent,0);
        builder1.setContentIntent(pi);
        Notification notify1=builder1.build();


        // int i = (int) Math.round(Math.random()*10);
            notifyMgr.notify(1, notify1);

    }


}

