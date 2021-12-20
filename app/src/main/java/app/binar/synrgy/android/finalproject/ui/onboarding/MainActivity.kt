package app.binar.synrgy.android.finalproject.ui.onboarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.constant.Constant
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences(Constant.PREF_NAME, Context.MODE_PRIVATE)


        Handler(Looper.getMainLooper()).postDelayed({
            if (sharedPreferences.getBoolean(Constant.IS_LOGIN, false)) {
                startActivity(Intent(this, HomeNavigationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, SplashScreen::class.java))
                finish()
            }
        }, 3000)
    }
}