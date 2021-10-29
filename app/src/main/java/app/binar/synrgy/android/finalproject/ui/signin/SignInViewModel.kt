package app.binar.synrgy.android.finalproject.ui.signin

import android.content.SharedPreferences
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.constant.Const
import app.binar.synrgy.android.finalproject.constant.Const.PHONE_PATTERN
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignInViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    private val isButtonEnable : MutableLiveData<Boolean> = MutableLiveData(false)
    private val goHomePage : MutableLiveData<Boolean> = MutableLiveData(false)
    private val showLoading : MutableLiveData<Boolean> = MutableLiveData(false)
    val showMessageEmail : MutableLiveData<String> = MutableLiveData()
    val showMessagePassword : MutableLiveData<String> = MutableLiveData()

    private var email : String = ""
    private var password : String = ""


    fun onChangeEmail(email: String){
        this.email = email
        if (!validateEmail(email)){
            showMessageEmail.value = "format email harus benar"
        }else{
            validateEmail(email)
        }
    }

    fun onChangePassword(password: String) {
        this.password = password
        if (!validatePassword(password)){
            showMessagePassword.value = "Password minimal 6 karakter & kombinasi huruf"
        }else{
            validatePassword(password)
        }
    }

    private fun validateEmail(email : String) : Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: String) : Boolean{
        val pattern : Pattern = Pattern.compile(Const.PASSWORD_PATTERN)
        val matcher : Matcher = pattern.matcher(password)
        return matcher.matches()
    }

    fun doSignIn(){
        /*
        * Hit API
        * Loading
        * Simpan ke sharedpreferences
        * jika error show message
        * */
    }



}