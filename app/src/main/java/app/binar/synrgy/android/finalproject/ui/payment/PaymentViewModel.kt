package app.binar.synrgy.android.finalproject.ui.payment

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivityPaymentBinding

class PaymentViewModel : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)

        val button50k = findViewById<Button>(R.id.button_50k)
        val button100k = findViewById<Button>(R.id.button_100k)
        val button200k = findViewById<Button>(R.id.button_200k)
        val button500k = findViewById<Button>(R.id.button_500k)
        val button1000k = findViewById<Button>(R.id.button_1000k)
        val button2000k = findViewById<Button>(R.id.button_2000k)

        button50k.setOnClickListener(this)
        button100k.setOnClickListener(this)
        button200k.setOnClickListener(this)
        button500k.setOnClickListener(this)
        button1000k.setOnClickListener(this)
        button2000k.setOnClickListener(this)
    }

    override fun onClick(v: View?) {


        when (v?.getId()) {
            R.id.button_50k -> binding.button50k.setBackgroundColor(R.drawable.button_blue_primary)
            R.id.button_100k -> binding.button50k.setBackgroundColor(R.drawable.button_blue_primary);
            R.id.button_200k -> binding.button50k.setBackgroundColor(R.drawable.button_blue_primary);
            R.id.button_500k -> binding.button50k.setBackgroundColor(R.drawable.button_blue_primary);
            R.id.button_1000k -> binding.button50k.setBackgroundColor(R.drawable.button_blue_primary);
            R.id.button_2000k -> binding.button50k.setBackgroundColor(R.drawable.button_blue_primary);
            else -> secondFun()
        }
        when (v?.getId()) {
            R.id.button_50k -> binding.button50k.setBackgroundColor(R.drawable.button_border_blue);
            R.id.button_100k -> binding.button50k.setBackgroundColor(R.drawable.button_border_blue);
            R.id.button_200k -> binding.button50k.setBackgroundColor(R.drawable.button_border_blue);
            R.id.button_500k -> binding.button50k.setBackgroundColor(R.drawable.button_border_blue);
            R.id.button_1000k -> binding.button50k.setBackgroundColor(R.drawable.button_border_blue);
            R.id.button_2000k -> binding.button50k.setBackgroundColor(R.drawable.button_border_blue);
        }
    }

    private fun firstFun() {

    }

    private fun secondFun() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}