## Notifications Android O

![Image-Absolute](assets/android-oreo.png)

---

- Picture-in-Picture mode 
- Autofill framework 
- Downloadable fonts 
- Fonts in XML 
- Autosizing TextView 
- Adaptive icons 

+++

- Color management 
- New WebView APIs 
- Pinning shortcuts and widgets 
- Maximum screen aspect ratio 
- Multi-display support 
- Notifications 

---
### Notifications

---
## What is new in Notifications? 
- Snoozing
- Notification timeouts
- Notification settings
- Notification dismissal
- Background colors
- Messaging style
- Notification Channels

---
### Snoozing
![Image-Absolute](assets/snoozing.gif)

---
### Notification settings
![Image-Absolute](assets/notification_categories.gif)

---
### Notification timeouts
```kotlin
val mBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_action_icon)
                .setContentTitle(title)
                .setContentText(message)
                .setTimeoutAfter(5_000)              
```

@[5]

![Image-Absolute](assets/timeout.gif)

---
### Notification dismissal

```kotlin
class NotificationListener : NotificationListenerService() {

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?, rankingMap: RankingMap?) {
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?, rankingMap: RankingMap?, reason: Int) {
    }
}
```
@[9-10]

---
### Background colors

```kotlin
return Notification.Builder(context, notificationChannel)
        .setContentTitle("Notification title")
        .setSmallIcon(android.R.drawable.sym_def_app_icon)
        .setContentText("Notification text")
        .setColorized(true)
        .setColor(Color.RED)
        .setOngoing(true)
        .build()
```

@[5-6]

<img align="right" width="300" height="500" src="./assets/notification_foreground_colorized.png">
<img align="left" width="300" height="500" src="./assets/notification_foreground.png">

---
### Messaging style

```kotlin
return Notification.Builder(context, notificationChannel)
    .setContentTitle("Notification")
    .setSmallIcon(android.R.drawable.sym_def_app_icon)
    .setContentText("Notification MessagingStyle")
    .setStyle(Notification.MessagingStyle("Me")
            .setConversationTitle("Team lunch")
            .addMessage("Hi", 2, null) // Pass in null for user.
            .addMessage("What's up?", 3, "Coworker")
            .addMessage("Not much", 4, null)
            .addHistoricMessage(Notification.MessagingStyle.Message("Historic Message - not visible", 5, null)))
    .build()
```
@[7-9]
@[10]

<img width="300" height="500" src="./assets/notification_messagin_style.png">

---
### Notification Channels

---
## Thanks!

### Links
https://developer.android.com/about/versions/oreo/android-8.0.html#notifications
