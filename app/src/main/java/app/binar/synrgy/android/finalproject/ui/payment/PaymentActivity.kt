package app.binar.synrgy.android.finalproject.ui.payment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.view.marginStart
import androidx.core.widget.doAfterTextChanged
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.ActivityPaymentBinding
import app.binar.synrgy.android.finalproject.utils.Const
import com.google.android.material.snackbar.Snackbar
import org.kodejava.android.MoneyTextWatcher
import java.math.BigDecimal
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
            binding.boxNominal.setText("${formatter.format(50000)}")
        }

        binding.button100k.setOnClickListener {
            binding.boxNominal.setText("${formatter.format(100000)}")
        }

        binding.button200k.setOnClickListener {
            binding.boxNominal.setText("${formatter.format(50000)}")
        }

        binding.button500k.setOnClickListener {
            binding.boxNominal.setText("${formatter.format(200000)}")
        }

        binding.button1000k.setOnClickListener {
            binding.boxNominal.setText("${formatter.format(1000000)}")
        }

        binding.button1500k.setOnClickListener {
            binding.boxNominal.setText("${formatter.format(1500000)}")
        }

        binding.buttonPay.setOnClickListener {
            viewModel.doPayment()
            viewModel.doPaymentStatus()
        }

        binding.boxNominal.addTextChangedListener(MoneyTextWatcher(binding.boxNominal))
        binding.boxNominal.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                binding.boxNominal.setHint("0")
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                binding.textCurrency.visibility = View.VISIBLE
            }
        })


//        binding.radiogroupBankTransfer.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
//                radiogroupBankTransfer, id ->
//            //val id: Int = radiogroupBankTransfer.checkedRadioButtonId
//            when (id) {
//                binding.radioBankBca.id -> {
//                    binding.radiogroupEWalet.clearCheck()
//                    viewModel.paymentAgentCode = "014"
//                    viewModel.paymentAgentId = 1
//                }
//                binding.radioBankMandiri.id -> {
//                    binding.radiogroupEWalet.clearCheck()
//                    viewModel.paymentAgentCode = "008"
//                    viewModel.paymentAgentId = 2
//                }
//            }
//        })
//
//        binding.radiogroupEWalet.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
//                radiogroupEWalet, id ->
//            //val id: Int = radiogroupEWalet.checkedRadioButtonId
//            when (id) {
//                binding.radioGopay.id -> {
//                    binding.radiogroupBankTransfer.clearCheck()
//                    viewModel.paymentAgentCode = phoneNumber!!
//                    viewModel.paymentAgentId = 3
//                }
//                binding.radioOvo.id -> {
//                    binding.radiogroupBankTransfer.clearCheck()
//                    viewModel.paymentAgentCode = phoneNumber!!
//                    viewModel.paymentAgentId = 4
//                }
//            }
//        })

        var radioGroupBank: RadioGroup = findViewById(R.id.radiogroup_bank_transfer)
        var radioGroupEWalet: RadioGroup = findViewById(R.id.radiogroup_e_walet)

        var radioBCA: RadioButton = findViewById(R.id.radio_bank_bca)
        var radioMandiri: RadioButton = findViewById(R.id.radio_bank_mandiri)
        var radioOVO: RadioButton = findViewById(R.id.radio_ovo)
        var radioGopay: RadioButton = findViewById(R.id.radio_gopay)

        radioGroupBank.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == radioBCA.id) {
                radioGroupEWalet.clearCheck()
                viewModel.paymentAgentCode = "014"
                viewModel.paymentAgentId = 1
            } else if (checkedId == radioMandiri.id) {
                radioGroupEWalet.clearCheck()
                viewModel.paymentAgentCode = "008"
                viewModel.paymentAgentId = 2
            }
        }

        radioGroupEWalet.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == radioGopay.id) {
                radioGroupBank.clearCheck()
                viewModel.paymentAgentCode = phoneNumber!!
                viewModel.paymentAgentId = 3
            } else if (checkedId == radioOVO.id) {
                radioGroupBank.clearCheck()
                viewModel.paymentAgentCode = phoneNumber!!
                viewModel.paymentAgentId = 4
            }
        }

//        radioBCA.setOnCheckedChangeListener { buttonView, isChecked ->
//            radioBCA.isChecked
//            radioMandiri.isChecked = false
//            radioGroupEWalet.clearCheck()
//            viewModel.paymentAgentCode = "014"
//            viewModel.paymentAgentId = 1
//        }
//
//        radioMandiri.setOnCheckedChangeListener { buttonView, isChecked ->
//            radioMandiri.isChecked
//            radioBCA.isChecked = false
//            radioGroupEWalet.clearCheck()
//            viewModel.paymentAgentCode = "008"
//            viewModel.paymentAgentId = 2
//        }
//
//        radioGopay.setOnCheckedChangeListener { buttonView, isChecked ->
//            radioGopay.isChecked
//            radioOVO.isChecked = false
//            radioGroupBank.clearCheck()
//            viewModel.paymentAgentCode = phoneNumber!!
//            viewModel.paymentAgentId = 3
//        }
//
//        radioOVO.setOnCheckedChangeListener { buttonView, isChecked ->
//            radioOVO.isChecked
//            radioGopay.isChecked = false
//            radioGroupBank.clearCheck()
//            viewModel.paymentAgentCode = phoneNumber!!
//            viewModel.paymentAgentId = 4
//        }

//        radioGroupBank.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
//                radiogroupBankTransfer, id ->
//            var id: Int = radiogroupBankTransfer.checkedRadioButtonId
//            when (id) {
//                radioBCA.id -> {
//                    radioGroupEWalet.clearCheck()
//                    viewModel.paymentAgentCode = "014"
//                    viewModel.paymentAgentId = 1
//                }
//                radioMandiri.id -> {
//                    radioGroupEWalet.clearCheck()
//                    viewModel.paymentAgentCode = "008"
//                    viewModel.paymentAgentId = 2
//                }
//            }
//        })
//
//        radioGroupEWalet.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
//                radiogroupEWalet, id ->
//            var id: Int = radiogroupEWalet.checkedRadioButtonId
//            when (id) {
//                radioOVO.id -> {
//                    radioGroupBank.clearCheck()
//                    viewModel.paymentAgentCode = phoneNumber!!
//                    viewModel.paymentAgentId = 3
//                }
//                radioGopay.id -> {
//                    radioGroupBank.clearCheck()
//                    viewModel.paymentAgentCode = phoneNumber!!
//                    viewModel.paymentAgentId = 4
//                }
//            }
//        })

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

//        var clicked: Boolean
//
//        binding.button1000k.setOnClickListener{
//            clicked = true
//            if (!clicked == true) {
//                binding.button1000k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button1000k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("1000000")
//            }
//            else {
//                binding.button1000k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button1000k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button2000k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button2000k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button2000k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("2000000")
//            }
//            else {
//                binding.button2000k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button2000k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button200k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button200k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button200k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("200000")
//            }
//            else {
//                binding.button200k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button200k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button100k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button100k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button100k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("100000")
//            }
//            else {
//                binding.button100k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button100k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button500k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button500k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button500k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("500000")
//            }
//            else {
//                binding.button500k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button500k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
//
//        binding.button50k.setOnClickListener{
//            clicked = true
//            if (!clicked) {
//                binding.button50k.setBackgroundColor(
//                    ContextCompat.getColor(
//                        this,
//                        R.color.blue_primary
//                    )
//                )
//                binding.button50k.setTextColor(ContextCompat.getColor(this, R.color.white))
//                binding.boxNominal.setText("50000")
//            }
//            else {
//                binding.button50k.setBackgroundColor(R.drawable.button_border_blue)
//                binding.button50k.setTextColor(ContextCompat.getColor(this, R.color.black))
//                binding.boxNominal.setText("0")
//            }
//        }
    }
}