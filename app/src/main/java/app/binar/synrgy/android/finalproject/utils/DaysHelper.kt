package app.binar.synrgy.android.finalproject.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit

object DaysHelper {
    @SuppressLint("SimpleDateFormat")
    fun getDaysHelper(startDate : String, endDate : String) : String{
        val parseStartDate = SimpleDateFormat("yyyy-MM-dd").parse(startDate)
        val parseEndDate = SimpleDateFormat("yyyy-MM-dd").parse(endDate)
        val diff = parseEndDate.time - parseStartDate.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS).toString()
    }

    fun dateFormatter(time : String): String {
        val parser : SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter : SimpleDateFormat = SimpleDateFormat("HH:mm dd-MM-yyyy")
        return formatter.format(parser.parse(time))
    }
}