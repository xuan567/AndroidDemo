package com.example.servicetest2;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private DownloadBinder mBinder = new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService","startDown");

        }
        public int getProgress(){
            Log.d("MyService","getProgress");
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
        super.onCreate();
        Log.d("MyService","onCreate");
    }
   @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d("MyService","onStartCommand");
        return super.onStartCommand(intent,flags,startId);
   }
   @Override
    public void onDestroy(){
       super.onDestroy();
        Log.d("MyService","onDestroy");
   }

}
