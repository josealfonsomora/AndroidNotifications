package com.josealfonsomora.androidnotifications

import android.app.Notification
import android.content.Context
import android.graphics.Color
import android.support.v4.app.NotificationCompat


class NotificationFactory {
    companion object {
        fun newSimpleNotification(context: Context, notificationChannel: String): Notification {
            return NotificationCompat.Builder(context, notificationChannel)
                    .setContentTitle("Notification Title")
                    .setSmallIcon(android.R.drawable.sym_def_app_icon)
                    .setContentText("Hello World!").build()
        }

        fun newNotificationWithTimeOut(context: Context, notificationChannel: String, timeout: Long): Notification {
            return NotificationCompat.Builder(context, notificationChannel)
                    .setContentTitle("Notification Title")
                    .setSmallIcon(android.R.drawable.sym_def_app_icon)
                    .setContentText("This notification will be destroyed in %s".format(timeout.toString()))
                    .setTimeoutAfter(timeout * 1000).build()
        }

        fun newNotificationMessagingStyle(context: Context, notificationChannel: String): Notification {

            return Notification.Builder(context, notificationChannel)
                    .setContentTitle("Notification Title")
                    .setSmallIcon(android.R.drawable.sym_def_app_icon)
                    .setContentText("Notification MessagingStyle")
                    .setStyle(Notification.MessagingStyle("Me")
                            .setConversationTitle("Team lunch")
                            .addMessage("What's up?", 3, "Coworker")
                            .addMessage("Not much", 4, null)
                            .addHistoricMessage(Notification.MessagingStyle.Message("Historic Message - not visible", 5, null))
                            .addMessage("How about lunch?", 6, "Coworker"))
                    .build()
        }

        fun newColorizedNotification(context: Context, notificationChannel: String): Notification {
            return Notification.Builder(context, notificationChannel)
                    .setContentTitle("Notification title")
                    .setSmallIcon(android.R.drawable.sym_def_app_icon)
                    .setContentText("Notification text")
                    .setColorized(true)
                    .setColor(Color.RED)
                    .setOngoing(true)
                    .build()
        }
    }
}