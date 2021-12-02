package app.binar.synrgy.android.finalproject.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

object DaysHelper {
    @SuppressLint("SimpleDateFormat")
    fun getDaysHelper(startDate : String, endDate : String) : String{
        val parseStartDate = SimpleDateFormat("dd-MM-yyyy").parse(startDate)
        val parseEndDate = SimpleDateFormat("dd-MM-yyyy").parse(endDate)
        val diff = parseEndDate.time - parseStartDate.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS).toString()
    }
}