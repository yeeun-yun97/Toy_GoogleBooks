package com.github.yeeun_yun97.clone.googlebook.ui.component

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.github.yeeun_yun97.clone.googlebook.R

class SjNotification {

    companion object {
        private var notificationId = 1200
        private var CHANNEL_ID = "all_notifications"
        private var CHANNEL_NAME = "General Notifications"
        private var IMPORTANCE = NotificationManager.IMPORTANCE_DEFAULT
        private var description = "This is default channel used for all other notifications"

        fun notifyNotification(context: Context,title: String,text: String) {
            val notiBuilder = createBuilder(context, title, text)
            val notiChannel = createNotificationChannel()
            val notiManager = createNotificationManager(context, notiChannel)
            notiManager.notify(notificationId++, notiBuilder.build())
        }

        private fun createNotificationManager(
            context: Context, notificationChannel: NotificationChannel
        ): NotificationManager {
            val manager =context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(notificationChannel)
            return manager
        }

        private fun createNotificationChannel(): NotificationChannel {
            val mChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, IMPORTANCE)
            mChannel.description = description
            return mChannel
        }

        private fun createBuilder(
            context: Context, title: String, text: String
        ): NotificationCompat.Builder {
            return NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_menu_book_24)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
        }


    }
}