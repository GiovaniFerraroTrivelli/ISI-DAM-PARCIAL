package com.example.parcialej1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class Tarea extends AsyncTask<String, Integer, Long> {
    ArrayList<String> lista;
    private final Context context;
    CustomReceiver broadcastReceiver;

    public Tarea(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        lista = new ArrayList<>();

        broadcastReceiver = new CustomReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(CustomReceiver.NOTIFICATION_EVENT);
        this.context.registerReceiver(broadcastReceiver, filter);

        NotificationSender.createChannel(this.context);
    }

    @Override
    protected Long doInBackground(String... strings) {
        int count = strings.length;
        for(int i = 0; i < count; i++) {
            lista.add(strings[i]);
        }

        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        //NotificationSender.sendNotification(this.context, .get(0), lista.get(1));
        Intent intentNotification = new Intent();
        intentNotification.putExtra("lista",lista);
        intentNotification.setAction(CustomReceiver.NOTIFICATION_EVENT);
        this.context.sendBroadcast(intentNotification);
    }
}
