package app.binar.synrgy.android.finalproject.ui.loading

import android.content.Context
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import app.binar.synrgy.android.finalproject.databinding.DialogLoadingBinding

class LoadingDialog(context: Context): AppCompatDialog(context) {
    private lateinit var binding: DialogLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.setCancelable(false)
    }

    fun showLoading(value: Boolean) {
        if (value) {
            if (!isShowing) {
                this.dismiss()
            } else {
                if (isShowing) {
                    this.dismiss()
                }
            }
        }
    }
}