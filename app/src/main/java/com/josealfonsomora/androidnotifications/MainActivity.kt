package com.josealfonsomora.androidnotifications

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import com.josealfonsomora.androidnotifications.services.ForegroundService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    companion object {
        val CHANNEL_ID = "CHANNEL_ID"
        val CHANNEL_ID_2 = "CHANNEL_ID_2"
        val CHANNEL_BYPASS_DND = "CHANNEL_BYPASS"
        val GROUP_1 = "GROUP_1"
        val GROUP_2 = "GROUP_2"
    }

    private val mNotificationManager: NotificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the channel object with the unique ID FOLLOWERS_CHANNEL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationGroups()

            createNotificationChannel1()

            createNotificationChannel2()

            createNotificationChannelBypass()
        }
    }

    private fun createNotificationGroups() {
        mNotificationManager.createNotificationChannelGroup(NotificationChannelGroup(GROUP_1, "Group 1"))
        mNotificationManager.createNotificationChannelGroup(NotificationChannelGroup(GROUP_2, "Group 2"))
    }

    private fun createNotificationChannelBypass() {
        var bypass = NotificationChannel(
                CHANNEL_BYPASS_DND,
                "Channel Bypass Dnd",
                NotificationManager.IMPORTANCE_LOW
        )
        bypass.setBypassDnd(true)
        bypass.group = GROUP_2

        mNotificationManager.createNotificationChannel(bypass)
    }

    private fun createNotificationChannel2() {
        var notificationChannel2 = NotificationChannel(
                CHANNEL_ID_2,
                "Notification Channel 2",
                NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationChannel2.lightColor = Color.BLUE
        notificationChannel2.vibrationPattern = longArrayOf(0, 100, 500, 100, 500, 100, 500, 100, 500, 100)
        notificationChannel2.setShowBadge(false)
        notificationChannel2.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        notificationChannel2.group = GROUP_2

        mNotificationManager.createNotificationChannel(notificationChannel2)
    }

    private fun createNotificationChannel1() {
        var notificationChannel = NotificationChannel(
                CHANNEL_ID,
                "Notification Channel 1",
                NotificationManager.IMPORTANCE_HIGH
        )
        notificationChannel.lightColor = Color.RED
        notificationChannel.enableLights(true)
        notificationChannel.vibrationPattern = longArrayOf(0, 100, 500, 100, 500, 100, 500, 100, 500, 100)
        notificationChannel.enableVibration(true) // Not needed
        notificationChannel.setShowBadge(true)
        notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        notificationChannel.enableVibration(true);
        //            notificationChannel.setSound(plynkSound, audioAttributes)
        notificationChannel.group = GROUP_1
        notificationChannel.setBypassDnd(true)

        mNotificationManager.createNotificationChannel(notificationChannel)
    }

    override fun onResume() {
        super.onResume()

        simple_notification_button.setOnClickListener {
            val notification = NotificationFactory.newSimpleNotification(this, CHANNEL_ID)
            mNotificationManager.notify((111..9999).random(), notification)
        }

        timeout_notification.setOnClickListener {
            val notification = NotificationFactory.newNotificationWithTimeOut(this, CHANNEL_ID, 5)
            mNotificationManager.notify((111..9999).random(), notification)
        }

        messaging_style_notification.setOnClickListener {
            val notification = NotificationFactory.newNotificationMessagingStyle(this, CHANNEL_ID_2)
            mNotificationManager.notify((111..9999).random(), notification)
        }

        bypass_dnd.setOnClickListener {
            val notification = NotificationFactory.newSimpleNotification(this, CHANNEL_BYPASS_DND)
            mNotificationManager.notify((111..9999).random(), notification)
        }

        notification_service.setOnClickListener {
            val startIntent = Intent(this@MainActivity, ForegroundService::class.java)
            startIntent.setAction(Constants.STARTFOREGROUND_ACTION);
            startService(startIntent)
        }

        notification_service_stop.setOnClickListener {
            val stopIntent = Intent(this@MainActivity, ForegroundService::class.java)
            stopIntent.setAction(Constants.STOPFOREGROUND_ACTION);
            startService(stopIntent)
        }

        channel_changed.setOnClickListener {
            val channel = mNotificationManager.getNotificationChannel(CHANNEL_ID)
            if (channel.importance != NotificationManager.IMPORTANCE_HIGH) {
                // Importance changed
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Please, let me annoy you")
                builder.setMessage("Set the channel importance back to Urgent")
                builder.setPositiveButton(android.R.string.yes, DialogInterface.OnClickListener { dialog, _ ->
                    goToNotificationChannelSettings(CHANNEL_ID)
                    finish()
                })
                builder.create().show()
            }

        }

    }

    private fun goToNotificationChannelSettings(channel: String) {
        val i = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS)
        i.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
        i.putExtra(Settings.EXTRA_CHANNEL_ID, channel)
        startActivity(i)
    }

    fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start
}
