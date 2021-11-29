package app.binar.synrgy.android.finalproject.ui.payment.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.DialogPopupPaymentBinding

class PopupDialog(context : Context) : AppCompatDialog(context){
    private lateinit var binding : DialogPopupPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogPopupPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setCanceledOnTouchOutside(true)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun showDialog(value: Boolean) {
        if (value) {
            if (!isShowing) {
                this.show()
            }
        } else {
            if (isShowing) {
                this.dismiss()
            }
        }
    }
}