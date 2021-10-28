package app.binar.synrgy.android.finalproject.ui.signin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.constant.Const
import app.binar.synrgy.android.finalproject.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    private lateinit var viewModel: SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        inisialisasi sharedpreferences
        val sharedPreferences : SharedPreferences = applicationContext.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)
//        viewmodel initial
        viewModel = SignInViewModel(sharedPreferences)

        
        binding.phone.doAfterTextChanged {
            val phone = it.toString().trim()
            viewModel.onChangePhone(phone)
        }

        binding.password.doAfterTextChanged {
            val password = it.toString().trim()
            viewModel.onChangePassword(password)
        }

//        show message error
        viewModel.showMessagePhone.observe(this,{
            binding.phone.error = it
        })
        viewModel.showMessagePassword.observe(this,{
            binding.password.error = it
        })

    }
}