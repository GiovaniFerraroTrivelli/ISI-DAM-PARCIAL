package com.example.parcialej1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class CustomReceiver extends BroadcastReceiver {
    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    public static final String NOTIFICATION_EVENT = "com.example.parcialej1.NOTIFICATION";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        if (NOTIFICATION_EVENT.equalsIgnoreCase(intent.getAction())) {
            ArrayList<String> lista = intent.getStringArrayListExtra("lista");
            NotificationSender.sendNotification(context, lista.get(0), lista.get(1).equals("Hombre") ? "caballero" : "señorita");
        }
    }
}
