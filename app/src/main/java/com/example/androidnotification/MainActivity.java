package com.example.androidnotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    //All This things for display a notification
       //notification channel-(1)channel id (2)channel name (3)channel descroption
       //notification builder
       //notification manager

    private static final String CHANNEL_ID = "channelid";
    private static final String CHANNEL_NAME = "channelname";
    private static final String CHANNEL_DESCRIPTION = "channel description";
    //private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Notification Channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        findViewById(R.id.show_notification_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });
    }



    //this method is for display the notification to notification bar
    private void displayNotification(){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Wow it is working")
                .setContentText("your first notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mNotificationManager = NotificationManagerCompat.from(this);
        mNotificationManager.notify(1,mBuilder.build());
    }
}
