package app.binar.synrgy.android.finalproject.ui.signin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.constant.Const
import app.binar.synrgy.android.finalproject.databinding.ActivitySignInBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity
import app.binar.synrgy.android.finalproject.ui.loading.LoadingDialog
import com.google.android.material.snackbar.Snackbar

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    private lateinit var viewModel: SignInViewModel
    private val loading by lazy { LoadingDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inisialisasi sharedpreferences
        val sharedPreferences : SharedPreferences =
            applicationContext.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)

        // viewmodel initial
        viewModel = SignInViewModel(sharedPreferences)

        viewModel.isButtonEnable.observe(this, {
            binding.buttonSignIn.isEnabled = it
        })

        viewModel.showLoading.observe(this, {
            loading.showLoading(it)
        })

        viewModel.showErrorMessage.observe(this, {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })

        viewModel.goHomePage.observe(this, {
            if (it) {
                startActivity(
                    Intent(this, HomeNavigationActivity::class.java).apply {
                        this.addFlags(
                            Intent.FLAG_ACTIVITY_CLEAR_TOP or
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                                    Intent.FLAG_ACTIVITY_NEW_TASK
                        )
                    }
                )
            }
        })

        binding.email.doAfterTextChanged {
            val email = it.toString().trim()
            viewModel.onChangeEmail(email)
        }

        binding.password.doAfterTextChanged {
            val password = it.toString().trim()
            viewModel.onChangePassword(password)
        }

        //  show message error
        viewModel.showMessageEmail.observe(this,{
            binding.email.error = it
        })
        viewModel.showMessagePassword.observe(this,{
            binding.password.error = it
        })

    }
}