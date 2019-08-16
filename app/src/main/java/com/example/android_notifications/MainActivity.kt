package com.example.android_notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID = 7654
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_notification.setOnClickListener { p0 ->
            val channelId = "$packageName.notificationchannel"
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Notification Channel"
                val importance = NotificationManager.IMPORTANCE_HIGH
                val description = "Notification App Project"

                val channel = NotificationChannel(channelId, name, importance)
                channel.description = description

                notificationManager.createNotificationChannel(channel)
            }

            val builder = NotificationCompat.Builder(this, channelId)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setSmallIcon(android.R.drawable.ic_menu_directions)
            notificationManager.notify(NOTIFICATION_ID, builder.build())
        }
    }
}
