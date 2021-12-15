package app.binar.synrgy.android.finalproject.ui.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.binar.synrgy.android.finalproject.databinding.ActivityProfileVerificationBinding
import app.binar.synrgy.android.finalproject.ui.payment.dialog.PopupDialog

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileVerificationBinding
    private lateinit var viewModel: ProfileViewModel
    private val dialog by lazy { PopupDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding
    }
}