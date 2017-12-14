package com.josealfonsomora.androidnotifications.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import android.os.IBinder
import com.josealfonsomora.androidnotifications.Constants
import com.josealfonsomora.androidnotifications.NotificationFactory


class ForegroundService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        // Used only in case of bound services.
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent!!.getAction().equals(Constants.STARTFOREGROUND_ACTION)) {
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val CHANNEL_FOREGROUND = "CHANNEL_FOREGROUND"
            val notificationChannel = NotificationChannel(
                    CHANNEL_FOREGROUND,
                    "Foreground Channel",
                    NotificationManager.IMPORTANCE_MIN
            )

            // Configure the notification channel.
            notificationChannel.description = "Foreground Channel description"
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_SECRET
            mNotificationManager.createNotificationChannel(notificationChannel)

            val notification = NotificationFactory.newColorizedNotification(this, CHANNEL_FOREGROUND)

            startForeground(1234, notification)

        }

        if (intent.getAction().equals(Constants.STOPFOREGROUND_ACTION)) {
            stopSelf()
        }

        return Service.START_STICKY
    }
}