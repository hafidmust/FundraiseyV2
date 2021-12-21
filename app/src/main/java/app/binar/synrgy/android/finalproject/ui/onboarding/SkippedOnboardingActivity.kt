package app.binar.synrgy.android.finalproject.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivitySkippedOnboardingBinding
import app.binar.synrgy.android.finalproject.ui.signin.SignInActivity
import app.binar.synrgy.android.finalproject.ui.signup.SignupActivity

class SkippedOnboardingActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySkippedOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkippedOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
        binding.imageBack.setOnClickListener { finish() }
        binding.tvGuest.setOnClickListener {
            Toast.makeText(this, "Available soon!", Toast.LENGTH_LONG).show();
        }
    }
}