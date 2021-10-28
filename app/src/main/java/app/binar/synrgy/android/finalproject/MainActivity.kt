package app.binar.synrgy.android.finalproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import app.binar.synrgy.android.finalproject.constant.Const

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)

    Handler(Looper.getMainLooper()).postDelayed({
        if (sharedPreferences.getBoolean(Const.IS_LOGIN, false)) {
            // startActivity -> HomeNavigation
        } else {
            // startActivity -> SignIn
        }
    }, 5000)
    }

}