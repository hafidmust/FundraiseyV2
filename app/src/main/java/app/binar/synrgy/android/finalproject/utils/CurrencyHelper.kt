package app.binar.synrgy.android.finalproject.utils

import java.text.NumberFormat
import java.util.*

object CurrencyHelper {
    fun toIdrCurrency(nominal: Int?): String? {
        val format : NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance("IDR")

        return format.format(nominal)
    }


}