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
- Notification dots
- Messaging style
- Notification Channels

---
### Snoozing
![Image-Absolute](assets/snoozing.gif)

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
### Notification settings
![Image-Absolute](assets/notification_categories.gif)

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

+++

![Image-Absolute](assets/notification_access.png)

---
### Background colors

---
### Notification dots

---
### Messaging style

---
### Notification Channels