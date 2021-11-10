package app.binar.synrgy.android.finalproject.ui.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import app.binar.synrgy.android.finalproject.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import android.R
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewmodel: SignupViewModel
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

        viewmodel.showMessageEmail.observe(this, {
            binding.textEmail.error = it
        })
        viewmodel.showMessagePassword.observe(this, {
            binding.password.error = it
        })
        viewmodel.showMessagePhone.observe(this, {
            binding.textPhone.error = it
        })
        viewmodel.isButtonEnable.observe(this, {
            binding.buttonSignUp.isEnabled = it
        })
        binding.buttonSignUp.setOnClickListener {
            viewmodel.doSignUp()

        }
        viewmodel.showMessageAPI.observe(this, {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })
        binding.radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, id ->
            when (id) {
                binding.rbMale.id ->
                    viewmodel.gender = "male"
                binding.rbFemale.id ->
                    viewmodel.gender = "female"
            }
        })

    }

    fun onPPClicked(view: android.view.View) {
        if (view is CheckBox){
            val checked : Boolean = view.isChecked
            when(view.id){
                binding.checkboxPrivacy.id -> {
                    viewmodel.isPPChecked = checked
                }

            }
        }
    }
}