package app.binar.synrgy.android.finalproject.ui.profile.form

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.HomeAPI
import app.binar.synrgy.android.finalproject.data.payment.TransactionStatusRequest
import app.binar.synrgy.android.finalproject.data.profile.ProfileFormRequest
import app.binar.synrgy.android.finalproject.data.profile.VerificationData
import app.binar.synrgy.android.finalproject.model.ErrorModel
import app.binar.synrgy.android.finalproject.utils.Const
import app.binar.synrgy.android.finalproject.utils.DummyBearer
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody

class ProfileFormViewModel() : ViewModel() {
    val profileResponse: MutableLiveData<VerificationData> = MutableLiveData()
    val isButtonEnable: MutableLiveData<Boolean> = MutableLiveData(false)
    val showLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val showErrorMessage: MutableLiveData<String> = MutableLiveData()
    private lateinit var homeAPI: HomeAPI

    lateinit var citizenIDTemp: String
    lateinit var fullNameTemp: String
    lateinit var genderTemp: String
    lateinit var phoneNumberTemp: String
    lateinit var dateOfBirthTemp: String
    lateinit var bankAccountNumberTemp: String
    lateinit var selfiePhoto: String
    lateinit var citizenIDPhoto: String

    fun onViewLoaded() {
        getUserData()
    }

    fun onChangeCitizenID(citizenID: String) {
        this.citizenIDTemp = citizenID
//        validateInput()
    }

    fun onChangeFullName(fullName: String) {
        this.fullNameTemp = fullName
//        validateInput()
    }

    fun onChangeGender(gender: String) {
        this.genderTemp = gender
//        validateInput()
    }

    fun onChangePhoneNumber(phoneNumber: String) {
        this.phoneNumberTemp = phoneNumber
//        validateInput()
    }

    fun onChangeDOB(DOB: String) {
        this.dateOfBirthTemp = DOB
//        validateInput()
    }

    fun onChangeBankAccount(bankAccountNumber: String) {
        this.bankAccountNumberTemp = bankAccountNumber
//        validateInput()
    }

//    fun validateInput() {
//        isButtonEnable.value =
//            citizenID.isNotEmpty() &&
//                    fullName.isNotEmpty() &&
//                    gender.isNotEmpty() &&
//                    phoneNumber.isNotEmpty() &&
//                    dateOfBirth.isNotEmpty() &&
//                    bankAccountNumber.isNotEmpty()
////                    citizenIDPhoto.isNotEmpty() &&
////                    selfiePhoto.isNotEmpty()
//    }

    fun updateProfile(){
//        postCitizenID()
//        postSelfie()
        updateUserProfile()
    }


    fun getUserData() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val responseVerification = homeAPI.getVerificationData("Bearer ${DummyBearer.auth}")

            withContext(Dispatchers.Main) {
                if (responseVerification.isSuccessful) {
                    profileResponse.value = responseVerification.body()?.data
                }
            }
        }
    }

    fun postSelfie(body: MultipartBody.Part) {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.uploadSelfie("Bearer ${DummyBearer.auth}", file = body)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val image = response.body()?.url ?: ""
                    println("url : $image")

                } else {
                    showErrorMessage.value = response.message()
                }
            }
        }
    }

    fun postCitizenID(body: MultipartBody.Part) {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = homeAPI.uploadSelfie("Bearer ${DummyBearer.auth}", file = body)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val image = response.body()?.url ?: ""
                    println("url : $image")

                } else {
                    showErrorMessage.value = response.message()
                }
            }
        }
    }

    fun updateUserProfile() {
        homeAPI = HomeAPI.getInstance().create(HomeAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val request = ProfileFormRequest(
                citizenID = citizenIDTemp,
                fullName = fullNameTemp,
                gender = genderTemp,
                phoneNumber = phoneNumberTemp,
                dateOfBirth = dateOfBirthTemp,
                bankAccountNumber = bankAccountNumberTemp
            )
            val response = homeAPI.editUserProfile("Bearer ${DummyBearer.auth}", request)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    if (response.body()?.status == 403) {
                    }
                } else {
                    val error =
                        Gson().fromJson(response.errorBody()?.string(), ErrorModel::class.java)
                    showErrorMessage.value = error.message
                }
            }
        }
    }
}