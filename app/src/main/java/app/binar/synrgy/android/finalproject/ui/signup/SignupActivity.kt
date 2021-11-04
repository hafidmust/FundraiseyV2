package app.binar.synrgy.android.finalproject.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import app.binar.synrgy.android.finalproject.databinding.ActivitySignUpBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    private lateinit var viewmodel : SignupViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = SignupViewModel()

        binding.textEmail.doAfterTextChanged {
            val email = it.toString().trim()
            viewmodel.onChangeEmail(email)
        }

        binding.password.doAfterTextChanged {
            val password = it.toString().trim()
            viewmodel.onChangePassword(password)
        }

        binding.textPhone.doAfterTextChanged {
            val phone = it.toString().trim()
            viewmodel.onChangePhone(phone)
        }

        viewmodel.showMessageEmail.observe(this,{
            binding.textEmail.error = it
        })
        viewmodel.showMessagePassword.observe(this,{
            binding.password.error = it
        })
        viewmodel.showMessagePhone.observe(this,{
            binding.textPhone.error = it
        })
        viewmodel.isButtonEnable.observe(this,{
            binding.buttonSignUp.isEnabled = it
        })
    }
}