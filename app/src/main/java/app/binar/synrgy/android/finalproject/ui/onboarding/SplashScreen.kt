package app.binar.synrgy.android.finalproject.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import app.binar.synrgy.android.finalproject.R
import com.bumptech.glide.Glide

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashcreen)
        supportActionBar?.hide()
        val imageView = ImageView(this)
        Glide.with(this)
            .asGif()
            .load(R.drawable.logo)
            .into(imageView)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, OnboardingActivity::class.java))
            finish()

        }, 3000)
    }
}