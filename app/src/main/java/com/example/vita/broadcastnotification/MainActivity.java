package com.example.vita.broadcastnotification;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReciever mBroadcastReciever;
    LocalBroadcastReceiver myLocalBroadcastReceiver;
    private LocalBroadcastManager mLocalBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("%%%%%%%%%%%%%", "线程号 ："+Thread.currentThread().getId());
        Log.i("%%%%%%%%%%%%%", "线程名字 ："+Thread.currentThread().getName());

        mBroadcastReciever = new MyBroadcastReciever();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.vita.broadcastnotification");//动态添加action，注册
        registerReceiver(mBroadcastReciever,intentFilter);

        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        myLocalBroadcastReceiver = new LocalBroadcastReceiver();
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction(Intent.ACTION_CAMERA_BUTTON);
        mLocalBroadcastManager.registerReceiver(myLocalBroadcastReceiver,intentFilter1);

        ImageView imageView = (ImageView)findViewById(R.id.img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLocalBroadcastManager.sendBroadcast(new Intent(Intent.ACTION_CAMERA_BUTTON));
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReciever);
        mLocalBroadcastManager.unregisterReceiver(myLocalBroadcastReceiver);

    }
}
