## Notifications Android O

![Image-Absolute](assets/android-oreo.png)

---
### Android Oreo API 26 
##### Released August 2017

- Picture-in-Picture mode 
- Autofill framework 
- Downloadable fonts 
- Fonts in XML 
- Autosizing TextView 
- Adaptive icons 

+++
### Android Oreo API 26
##### Released August 2017

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

@[5](Time in milliseconds)

![Image-Absolute](assets/timeout.gif)

---
### Notification settings
![Image-Absolute](assets/notification_categories.gif)

---
### Notification dismissal

---
### Background colors

---
### Notification dots

---
### Messaging style

---
### Notification Channels