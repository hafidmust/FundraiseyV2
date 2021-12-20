package app.binar.synrgy.android.finalproject.ui.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import app.binar.synrgy.android.finalproject.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import android.R
import android.app.DatePickerDialog
import android.content.Intent
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity
import app.binar.synrgy.android.finalproject.ui.loading.LoadingDialog
import app.binar.synrgy.android.finalproject.ui.signin.SignInActivity
import java.util.*


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewmodel: SignupViewModel
    private val loading by lazy { LoadingDialog(this) }
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

        binding.tvlogin.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

//        binding.checkboxPrivacy.setOnCheckedChangeListener { buttonView, isChecked ->
//            if(isChecked){
//                viewmodel.isPPChecked = true
//            } else{
//                viewmodel.isPPChecked = false
//            }
//        }

        binding.datePick.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, timeOfYear, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                binding.datePick.text = ("$dayOfMonth / ${monthOfYear + 1} / $timeOfYear")

            }, year, month, day)

            dpd.show()
            viewmodel.onChangeDateOfBirth(binding.datePick.text as String)
        }
        viewmodel.showLoading.observe(this,{
            loading.showLoading(it)
        })
        viewmodel.isLoginSuccess.observe(this,{
            if (it){
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
    }

//    fun onPPClicked(view: android.view.View) {
//        if (view is CheckBox){
//            val checked : Boolean = view.isChecked
//            viewmodel.isPPChecked = checked
//            when(view.id){
//                binding.checkboxPrivacy.id -> {
//                    viewmodel.isPPChecked = checked
//                }
//
//            }
//        }
//    }
}