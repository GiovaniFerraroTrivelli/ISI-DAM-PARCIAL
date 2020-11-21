package com.example.parcialej1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationSender {
    public static void createChannel(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(CustomReceiver.NOTIFICATION_CHANNEL_ID, "Notificacion", importance);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void sendNotification(Context context, String nombre, String forma) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CustomReceiver.NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("¡Buenas tardes, " + forma + "!")
                .setContentText("Su nombre es " + nombre + ", ¿no es cierto?")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Notification notification = mBuilder.build();
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.notify(99, notification);
    }
}
