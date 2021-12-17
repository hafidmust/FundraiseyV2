package app.binar.synrgy.android.finalproject.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import app.binar.synrgy.android.finalproject.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import android.app.DatePickerDialog
import android.content.Intent
import android.view.View
import android.widget.*
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity
import app.binar.synrgy.android.finalproject.ui.loading.LoadingDialog
import java.text.SimpleDateFormat
import java.util.*


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewmodel: SignupViewModel
    private val loading by lazy { LoadingDialog(this) }
    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = SignupViewModel()

            val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

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

        binding.datePick.setOnClickListener (object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@SignupActivity,
                    dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show()
            }

        })



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

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        binding.datePick.text = sdf.format(calendar.getTime())
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

//    binding.checkboxPrivacy.setOnCheckedChangeListener { buttonView, isChecked ->
//        if(isChecked){
//            viewmodel.isPPChecked = true
//        }else{
//            viewmodel.isPPChecked = false
//        }
//    } di line 90

//    binding.textPrivacyPolicy.setOnClickListener {
//        // still in progress
//    } di line 67
//


}