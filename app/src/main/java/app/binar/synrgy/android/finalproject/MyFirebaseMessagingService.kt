package app.binar.synrgy.android.finalproject

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.NotificationManager
import android.media.RingtoneManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import java.util.concurrent.atomic.AtomicInteger

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("MyFirebase", "onNewToken: " + token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(
            "MyFirebase",
            "onMessageReceived: FROM: " + remoteMessage.from + " \n DATA: " + remoteMessage.data
        )
        sendNotification(this, remoteMessage)
    }

    fun sendNotification(context: Context, remoteMessage: RemoteMessage) {

        val channelId = "FundRaisey"

        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val extras = Bundle()
        extras.putString(notify_title, remoteMessage.notification?.title)
        extras.putString(notify_url, remoteMessage.data.get("pageUrl"))
        intent.putExtras(extras)
        intent.action = Intent.ACTION_VIEW

        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(
                applicationContext,
                NotificationID.iD,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

        val notificationBuilder =
            NotificationCompat.Builder(context.getApplicationContext(), channelId)
                .setSmallIcon(R.mipmap.logo)
                .setAutoCancel(true)
                .setLights(Color.BLUE, 500, 500)
                .setVibrate(longArrayOf(500, 500, 500))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setContentIntent(pendingIntent)
                .setContentTitle(remoteMessage.notification?.title)
                .setContentText(remoteMessage.notification?.body)

        val notificationManager = NotificationManagerCompat.from(context)

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "news",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        Glide.with(applicationContext)
            .asBitmap()
            .load(remoteMessage.notification?.imageUrl)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    //largeIcon
                    notificationBuilder.setLargeIcon(resource)
                    //Big Picture
                    notificationBuilder.setStyle(
                        NotificationCompat.BigPictureStyle().bigPicture(resource)
                    )
                    notificationManager.notify(NotificationID.iD, notificationBuilder.build())
                }
                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }

    companion object {
        const val notify_title: String = "Register as Startup Now!"
        const val notify_url: String = "https://fundraisey-final-project.vercel.app/"
    }

}

internal object NotificationID {
    private val c = AtomicInteger(100)
    val iD: Int
        get() = c.incrementAndGet()
}