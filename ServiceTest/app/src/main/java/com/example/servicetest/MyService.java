package com.example.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.icu.text.LocaleDisplayNames;
import android.os.Binder;
import android.os.IBinder;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.widget.Button;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    private DownloadBinder mBinder = new DownloadBinder();
    class DownloadBinder extends  Binder{
        public void startDownload(){
            Log.d("My service","start service");
        }
        public int getProgress(){
            Log.d("My service","getProgress");
            return 0;
        }
    }
    public MyService(){}
    @Override
    public IBinder onBind(Intent intent){
        return mBinder;
    }

    @Override
    public void onCreate(){
        Log.d("My service","onCreate");
        super.onCreate();
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d("My service","onStartCommand");
        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("My service", "onDestroy: ");
    }

}
