package app.binar.synrgy.android.finalproject.ui.onboarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.constant.Const
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity
import com.bumptech.glide.Glide

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)

        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        val imageView = ImageView(this)
        Glide.with(this)
            .asGif()
            .load(R.drawable.logo)
            .into(imageView)

        Handler(Looper.getMainLooper()).postDelayed({
            if (sharedPreferences.getBoolean(Const.IS_LOGIN, true)) {
                startActivity(Intent(this, HomeNavigationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, SlideActivity::class.java))
                finish()
            }
        }, 3000)
    }
}