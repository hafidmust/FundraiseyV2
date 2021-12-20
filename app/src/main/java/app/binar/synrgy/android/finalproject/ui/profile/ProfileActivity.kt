package app.binar.synrgy.android.finalproject.ui.profile

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.databinding.ActivityProfileVerificationBinding
import app.binar.synrgy.android.finalproject.ui.payment.dialog.PopupDialog
import app.binar.synrgy.android.finalproject.ui.profile.form.ProfileFormActivity
import app.binar.synrgy.android.finalproject.utils.Const

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileVerificationBinding
    private lateinit var viewModel: ProfileViewModel
    private val dialog by lazy { PopupDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val sharedPreferences = this.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)
        val isLogin = sharedPreferences.getBoolean(Const.IS_LOGIN, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        binding.buttonRegister.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("This action will take you to our website, continue?")
                .setCancelable(false)
                .setTitle("")
                .setPositiveButton("Proceed", { dialog, id ->
                    val url = "https://fundraisey-final-project.vercel.app/startup/login"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                })
                .setNegativeButton("Stay Here", { dialog, id ->
                    dialog.dismiss()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("")
            alert.show()
        }

        binding.buttonLogoutVerif.setOnClickListener {
            sharedPreferences.edit {
                putBoolean(Const.IS_LOGIN, false)
                apply()
            }
        }

        binding.arrowBack.setOnClickListener {
            onBackPressed()
        }

        binding.buttonUpdateData.setOnClickListener {
            val intentSendId = Intent(this, ProfileFormActivity::class.java).apply {}
            startActivity(intentSendId)

            viewModel.getVerification()
            viewModel.verificationResponse.observe(this, {
                when (isLogin) {
                    true -> {
                        when (it.verified) {
                            true -> {
                                binding.indicatorHeader.progress = 100
                                binding.iconUpdate.visibility = View.GONE
                                binding.emailUsernameBot.visibility = View.VISIBLE
                            }
                            false -> {
                                binding.indicatorHeader.progress = 50
                                binding.iconUpdate.visibility = View.VISIBLE
                                binding.boxProgress.visibility = View.VISIBLE
                                binding.emailUsernameBot.visibility = View.VISIBLE
                            }
                        }
                    }
                    false -> {
                        binding.boxProgress.visibility = View.VISIBLE
                        binding.indicatorHeader.progress = 0
                    }
                }
                binding.emailUsername.text = it.fullName
                binding.emailUsernameBot.text = it.email
            })
        }
    }
}