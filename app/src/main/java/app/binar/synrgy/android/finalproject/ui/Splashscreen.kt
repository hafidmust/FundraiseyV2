package app.binar.synrgy.android.finalproject.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivitySplashcreenBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity

class Splashscreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashcreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashcreen)

        Handler(Looper.getMainLooper()).postDelayed({

                startActivity(Intent(this, HomeNavigationActivity::class.java))
                finish()

        }, 3000)

    }
}