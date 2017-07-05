package com.example.vita.broadcastnotification;


import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.util.Log;
import android.view.WindowManager;


/**
 * Created by Vita on 2017/7/5.
 */

public class LocalBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("%%%%%%%%%%%%%", "线程号 ："+Thread.currentThread().getId());
        Log.i("%%%%%%%%%%%%%", "线程名字 ："+Thread.currentThread().getName());

        alertDialog(context,"本地广播提示","你拍了一张照片");

    }
    private void alertDialog(Context context,String title,String message){
        AlertDialog.Builder builder = new  AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("%%%%%%%%%%%%%", "onClick: ");
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        alertDialog.show();

    }
}
