package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.constant.Const

class HomeViewModel(val sharedPreferences: SharedPreferences) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun logout(){
        sharedPreferences.edit {
            this.putBoolean(Const.IS_LOGIN, false)
            apply()
        }
    }
}

