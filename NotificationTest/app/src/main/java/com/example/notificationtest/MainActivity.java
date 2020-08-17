package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);

    }
 //   @Override
//    public void onClick(View view){
//        switch (view.getId()) {
//            case R.id.send:
//                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                Notification notification = new NotificationCompat.Builder(this,"1")
//                        .setContentTitle("This is content tile")
//                        .setContentText("this is content text")
//                        .setWhen(System.currentTimeMillis())
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                        .build();
//                manager.notify(1, notification);
//                break;
//            default:
//                break;
//      }
// 该书中使用的Android版本较老，8.0以下，没有渠道这一说法，
// 所以使用的高版本Android系统，需要进行适配，即判断本机系统是否在8.0以上，是的话，添加渠道


        @Override

        public void onClick(View view) {

            switch (view.getId()){

                case R.id.send:
                    Intent intent = new Intent(this,NotificationActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                    NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){  //Android O （8.0）以上版本需要渠道



                        NotificationChannel notificationChannel = new NotificationChannel("channelid1","channelname",NotificationManager.IMPORTANCE_HIGH);//通知重要度，DEFAULT及以上，通知时手机默认会有振动

                        manager.createNotificationChannel(notificationChannel);

                    }

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"channelid1");

                    builder.setContentTitle("This is content title");
                    builder.setContentText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    builder.setWhen(System.currentTimeMillis());

                    builder.setSmallIcon(R.mipmap.ic_launcher);

                    builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                    builder.setContentIntent(pi);
                    builder.setAutoCancel(true);
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText("aaaaaaaaaaaaa" +
                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
                    builder.setPriority(NotificationCompat.PRIORITY_MAX);
                    builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background)));
                    manager.notify(1,builder.build());

                    break;

                default:

                    break;

            }

        }
}