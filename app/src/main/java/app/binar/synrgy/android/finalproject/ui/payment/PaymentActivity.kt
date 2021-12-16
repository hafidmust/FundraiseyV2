package app.binar.synrgy.android.finalproject.ui.payment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioGroup
import androidx.core.widget.doAfterTextChanged
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivityPaymentBinding
import app.binar.synrgy.android.finalproject.ui.payment.detail.DetailPaymentActivity
import app.binar.synrgy.android.finalproject.utils.Const
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding
    private lateinit var viewModel: PaymentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val sharedPreferences = getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)
        val phoneNumber = sharedPreferences.getString(Const.PHONE_NUMBER, "")
        viewModel = PaymentViewModel(sharedPreferences)

        val formatter: NumberFormat = DecimalFormat("#,###")
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance("IDR")

        binding.button50k.text = "${format.format(50_000)}"
        binding.button100k.text = "${format.format(100_000)}"
        binding.button200k.text = "${format.format(200_000)}"
        binding.button500k.text = "${format.format(500_000)}"
        binding.button1000k.text = "${format.format(1000_000)}"
        binding.button1500k.text = "${format.format(1500_000)}"

        binding.button50k.setOnClickListener {
            binding.boxNominal.setText("50000")
        }

        binding.button100k.setOnClickListener {
            binding.boxNominal.setText("100000")
        }

        binding.button200k.setOnClickListener {
            binding.boxNominal.setText("200000")
        }

        binding.button500k.setOnClickListener {
            binding.boxNominal.setText("500000")
        }

        binding.button1000k.setOnClickListener {
            binding.boxNominal.setText("1000000")
        }

        binding.button1500k.setOnClickListener {
            binding.boxNominal.setText("1500000")
        }

        binding.buttonPay.setOnClickListener {
            viewModel.doPayment()
            viewModel.doPaymentStatus()
        }

        binding.boxNominal.doAfterTextChanged {
            var amount: Int = binding.boxNominal.text.toString().toInt()
            viewModel.onChangeAmount(amount)
        }

        //binding.boxNominal.addTextChangedListener(MoneyTextWatcher(binding.boxNominal))
        binding.boxNominal.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                binding.boxNominal.setHint("0")
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                binding.textCurrency.visibility = View.VISIBLE
            }
        })

        binding.rgBank.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                binding.rbBca.id -> {
                    viewModel.paymentAgentCode = "014"
                    viewModel.paymentAgentId = 1
                    binding.rgWallet.clearCheck()
                }
                binding.rbMandiri.id ->{
                    viewModel.paymentAgentCode = "008"
                    viewModel.paymentAgentId = 2
                    binding.rgWallet.clearCheck()
                }

            }
        }
        binding.rgWallet.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                binding.rbGopay.id ->{
                    viewModel.paymentAgentCode = phoneNumber!!
                    viewModel.paymentAgentId = 3
                    binding.rgBank.clearCheck()
                }
                binding.rbObo.id ->{
                    viewModel.paymentAgentCode = phoneNumber!!
                    viewModel.paymentAgentId = 4
                    binding.rgBank.clearCheck()
                }
            }
        }


        viewModel.showMessageAPI.observe(this, {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })

        viewModel.paymentSuccess.observe(this, {
            if (it) {
                startActivity(
                    Intent(this, DetailPaymentActivity::class.java).apply {
                        this.addFlags(
                            Intent.FLAG_ACTIVITY_CLEAR_TOP or
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                                    Intent.FLAG_ACTIVITY_NEW_TASK
                        )
                    }
                )
            }
        })
    }
}

//package app.binar.synrgy.android.finalproject.ui.payment
//
//import android.content.Context
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.text.Editable
//import android.text.TextWatcher
//import android.view.View
//import androidx.core.widget.doAfterTextChanged
//import app.binar.synrgy.android.finalproject.R
//import app.binar.synrgy.android.finalproject.databinding.ActivityPaymentBinding
//import app.binar.synrgy.android.finalproject.ui.payment.detail.DetailPaymentActivity
//import app.binar.synrgy.android.finalproject.utils.Const
//import com.google.android.material.snackbar.Snackbar
//import java.text.DecimalFormat
//import java.text.NumberFormat
//import java.util.*
//
//
//class PaymentActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityPaymentBinding
//    private lateinit var viewModel: PaymentViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_payment)
//        binding = ActivityPaymentBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        supportActionBar?.hide()
//
//        val sharedPreferences = getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)
//        val phoneNumber = sharedPreferences.getString(Const.PHONE_NUMBER, "")
//        viewModel = PaymentViewModel(sharedPreferences)
//
//        val formatter: NumberFormat = DecimalFormat("#,###")
//        val format: NumberFormat = NumberFormat.getCurrencyInstance()
//        format.maximumFractionDigits = 0
//        format.currency = Currency.getInstance("IDR")
//
//        binding.button50k.text = "${format.format(50_000)}"
//        binding.button100k.text = "${format.format(100_000)}"
//        binding.button200k.text = "${format.format(200_000)}"
//        binding.button500k.text = "${format.format(500_000)}"
//        binding.button1000k.text = "${format.format(1000_000)}"
//        binding.button1500k.text = "${format.format(1500_000)}"
//
//        binding.button50k.setOnClickListener {
//            binding.boxNominal.setText("50000")
//        }
//
//        binding.button100k.setOnClickListener {
//            binding.boxNominal.setText("100000")
//        }
//
//        binding.button200k.setOnClickListener {
//            binding.boxNominal.setText("200000")
//        }
//
//        binding.button500k.setOnClickListener {
//            binding.boxNominal.setText("500000")
//        }
//
//        binding.button1000k.setOnClickListener {
//            binding.boxNominal.setText("1000000")
//        }
//
//        binding.button1500k.setOnClickListener {
//            binding.boxNominal.setText("1500000")
//        }
//
//        binding.buttonPay.setOnClickListener {
//            viewModel.doPayment()
//        }
//
//        binding.boxNominal.doAfterTextChanged {
//            var amount: Int = binding.boxNominal.text.toString().toInt()
//            viewModel.onChangeAmount(amount)
//        }
//
//        //binding.boxNominal.addTextChangedListener(MoneyTextWatcher(binding.boxNominal))
//        binding.boxNominal.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {
//                binding.boxNominal.setHint("0")
//            }
//
//            override fun beforeTextChanged(
//                s: CharSequence, start: Int,
//                count: Int, after: Int
//            ) {
//            }
//
//            override fun onTextChanged(
//                s: CharSequence, start: Int,
//                before: Int, count: Int
//            ) {
//                binding.textCurrency.visibility = View.VISIBLE
//            }
//        })
//
//        binding.rgBank.setOnCheckedChangeListener { group, checkedId ->
//            when(checkedId){
//                binding.rbBca.id -> {
//                    viewModel.paymentAgentCode = "014"
//                    viewModel.paymentAgentId = 1
//                    binding.rgWallet.clearCheck()
//                }
//                binding.rbMandiri.id ->{
//                    viewModel.paymentAgentCode = "008"
//                    viewModel.paymentAgentId = 2
//                    binding.rgWallet.clearCheck()
//                }
//            }
//        }
//        binding.rgWallet.setOnCheckedChangeListener { group, checkedId ->
//            when(checkedId){
//                binding.rbGopay.id ->{
//                    viewModel.paymentAgentCode = phoneNumber!!
//                    viewModel.paymentAgentId = 3
//                    binding.rgBank.clearCheck()
//                }
//                binding.rbObo.id ->{
//                    viewModel.paymentAgentCode = phoneNumber!!
//                    viewModel.paymentAgentId = 4
//                    binding.rgBank.clearCheck()
//                }
//            }
//        }
//
//        viewModel.showMessageAPI.observe(this, {
//            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
//        })
//
//        viewModel.paymentSuccess.observe(this, {
//            if (it) {
//                startActivity(
//                    Intent(this, DetailPaymentActivity::class.java).apply {
//                        this.addFlags(
//                            Intent.FLAG_ACTIVITY_CLEAR_TOP or
//                                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
//                                    Intent.FLAG_ACTIVITY_NEW_TASK
//                        )
//                    }
//                )
//            }
//        })
//    }
//}