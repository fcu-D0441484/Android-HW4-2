package com.example.owen.reciver;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class BR_Notification extends BroadcastReceiver {
    static int id=9487;
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("NAME");
        Intent newintent = new Intent();
        newintent =intent;
        newintent.setClass(context,ActivityNotification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,newintent,PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notify = null;
        if(Build.VERSION.SDK_INT>=16)
        {
            notify=newNotification(context,pendingIntent,"New Broadcast recived!!!",name);
        }
        else
        {
            notify=oldNotification(context,pendingIntent,"New Broadcast recived!!!",name);
        }
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id,notify);
    }
    @SuppressWarnings("deprecation")
    private Notification oldNotification(Context context,PendingIntent pi,String title,String name) {
        Notification notify = new Notification(R.mipmap.ic_launcher, title, System.currentTimeMillis());
        return notify;
    }
    @SuppressLint("NewApi")
    private Notification newNotification(Context context,PendingIntent pi,String title , String name)
    {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setAutoCancel(true);
        builder.setContentTitle(title);
        builder.setContentText(name);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker(name);
        builder.setWhen(System.currentTimeMillis());
        Notification notify = builder.build();
        return notify;

    }

}
