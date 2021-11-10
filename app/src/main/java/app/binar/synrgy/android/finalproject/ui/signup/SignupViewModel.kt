package app.binar.synrgy.android.finalproject.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.constant.Const
import app.binar.synrgy.android.finalproject.data.api.HomeAPI
import app.binar.synrgy.android.finalproject.data.api.signup.SignUpRequest
import app.binar.synrgy.android.finalproject.model.ErrorModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignupViewModel : ViewModel() {
    val showMessageEmail: MutableLiveData<String> = MutableLiveData()
    val showMessagePassword: MutableLiveData<String> = MutableLiveData()
    val showMessagePhone: MutableLiveData<String> = MutableLiveData()
    val isButtonEnable: MutableLiveData<Boolean> = MutableLiveData(false)
    val showMessageAPI: MutableLiveData<String> = MutableLiveData()
    val isLoginSuccess: MutableLiveData<Boolean> = MutableLiveData(false)

    private lateinit var homeAPI: HomeAPI
    private var email: String = ""
    private var password: String = ""
    private var phone: String = ""
    var gender : String = ""
    var isPPChecked : Boolean? = null



    fun onChangeEmail(email: String) {
        this.email = email
        if (!validateEmail(email)) {
            showMessageEmail.value = "format email harus benar"
        } else {
            validateEmail(email)
            validate()
        }
    }

    fun onChangePassword(password: String) {
        this.password = password
        if (!validatePassword(password)) {
            showMessagePassword.value = "Password minimal 6 karakter & kombinasi huruf"
        } else {
            validatePassword(password)
            validate()
        }
    }

    fun onChangePhone(phone: String) {
        this.phone = phone
        if (!validatePhone(phone)) {
            showMessagePhone.value = "Pastikan nomer hp 10-13 digit"
        } else {
            validatePhone(phone)
            validate()
        }
    }


    private fun validateEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: String): Boolean {
        val pattern: Pattern = Pattern.compile(Const.PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }

    private fun validatePhone(phone: String): Boolean {
        val pattern: Pattern = Pattern.compile(Const.PHONE_PATTERN)
        val matcher: Matcher = pattern.matcher(phone)
        return matcher.matches()
    }

    private fun validate() {
        isButtonEnable.value = email.isNotEmpty() && password.isNotEmpty() && phone.isNotEmpty() && gender.isNotEmpty()
                && isPPChecked == true
    }

    fun doSignUp() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val request = SignUpRequest(
                email = email,
                password = password,
                phoneNumber = phone,
                gender = gender
            )
            val response = homeAPI.postSignUp(request)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    if (response.body()?.status == 200) {
                        showMessageAPI.value = response.body()!!.message
                        isLoginSuccess.value = true
                    }
                } else {
                    val error =
                        Gson().fromJson(response.errorBody()?.string(), ErrorModel::class.java)
                    showMessageAPI.value = error.message

                }

            }
        }
    }

}