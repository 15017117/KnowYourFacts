package com.android.myapplicationdev.knowyourfacts;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 15017117 on 27/7/2017.
 */

public class ScheduledNotificationReceiver extends BroadcastReceiver{

    int reqCode = 12345;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, reqCode,i,PendingIntent.FLAG_CANCEL_CURRENT);

        //Build the notification
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("KNOW YOUR FACTS!");
        builder.setContentText("Fun Facts!");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Notification n = builder.build();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(123, n);


    }
}
