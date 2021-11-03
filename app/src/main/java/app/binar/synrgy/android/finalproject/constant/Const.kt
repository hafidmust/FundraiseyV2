package app.binar.synrgy.android.finalproject.constant

object Const {
    const val IS_LOGIN = "IS_LOGIN"
    const val PREF_NAME = "FINAL_PROJECT_A"
    const val EMAIL = "EMAIL"
    const val PASSWORD = "PASSWORD"
    const val GRANT_TYPE = "PASSWORD"
    const val CLIENT_ID = "CLIENT_APPS"
    const val CLIENT_SECRET = "PASSWORD"
    const val TOKEN = "TOKEN"

    // regex password pattern
    const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=!_()/*.,])(?=\\S+\$).{4,}\$"

    // regex phone pattern
    const val PHONE_PATTERN = "^0\\d{10,13}\$"
}