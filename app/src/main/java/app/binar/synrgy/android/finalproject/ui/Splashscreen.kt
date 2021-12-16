package app.binar.synrgy.android.finalproject.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivitySplashcreenBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity
import app.binar.synrgy.android.finalproject.utils.Const

class Splashscreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashcreenBinding
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashcreen)
        supportActionBar?.hide()

        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)

        sharedPreferences.edit {
            this.putString(Const.PHONE_NUMBER, "0876543210")
            apply()
        }

        Handler(Looper.getMainLooper()).postDelayed({

//                mediaPlayer = MediaPlayer.create(this,)

                startActivity(Intent(this, HomeNavigationActivity::class.java))
                finish()

        }, 3000)
    }
}