package app.binar.synrgy.android.finalproject.ui.signin

import android.content.SharedPreferences
import android.text.TextUtils
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.constant.Const
import app.binar.synrgy.android.finalproject.constant.Const.PHONE_PATTERN
import app.binar.synrgy.android.finalproject.data.api.HomeAPI
import app.binar.synrgy.android.finalproject.data.api.signIn.SignInRequest
import app.binar.synrgy.android.finalproject.model.ErrorModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignInViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    val isButtonEnable: MutableLiveData<Boolean> = MutableLiveData(false)
    val goHomePage: MutableLiveData<Boolean> = MutableLiveData(false)
    val showLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val showMessageEmail: MutableLiveData<String> = MutableLiveData()
    val showMessagePassword: MutableLiveData<String> = MutableLiveData()
    val showErrorMessage: MutableLiveData<String> = MutableLiveData()

    private lateinit var homeAPI: HomeAPI
    private var email: String = ""
    private var password: String = ""

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
            showMessagePassword.value = "Password minimal 8 karakter"
        } else {
            validatePassword(password)
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
    private fun validate(){
        isButtonEnable.value = email.isNotEmpty() && password.isNotEmpty()
    }

    fun doSignIn() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)

        showLoading.value = true

        CoroutineScope(Dispatchers.IO).launch {
            val request = SignInRequest(
                email = email,
                password = password
            )

            val response = homeAPI.postSignIn(request = request)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val signInResponse = response.body()
                    sharedPreferences.edit {
                        this.putBoolean(Const.IS_LOGIN, true)
                        this.putString(Const.EMAIL, signInResponse?.email)
                        this.putString(Const.PASSWORD, signInResponse?.password)
                        this.putString(Const.GRANT_TYPE, signInResponse?.password)
                        this.putString(Const.CLIENT_SECRET, signInResponse?.password)
                        this.putString(Const.CLIENT_ID, "client-apps")

                        apply()
                    }
                    showLoading.value = false
                    goHomePage.value = true
                } else {
                    showLoading.value = false
                    val error =
                        Gson().fromJson(response.errorBody()?.string(), ErrorModel::class.java)
                    showErrorMessage.value = error.message
                }
            }
        }
    }
}