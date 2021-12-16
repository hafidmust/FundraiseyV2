package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.data.portofolio.DataItem
import app.binar.synrgy.android.finalproject.databinding.FragmentPortofolioBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail.DetailHistoryActivity
import app.binar.synrgy.android.finalproject.utils.CurrencyHelper
import com.google.firebase.messaging.FirebaseMessaging


class PortofolioFragment : Fragment() {
    private lateinit var portofolioViewModel: PortofolioViewModel
    private var _binding: FragmentPortofolioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        _binding = FragmentPortofolioBinding.inflate(inflater, container, false)
        portofolioViewModel =
            ViewModelProvider(this).get(PortofolioViewModel::class.java)

        portofolioViewModel.onViewLoaded()

        val adapterPortofolio = AdapterPortofolio(listOf(),
            object : AdapterPortofolio.EventListener {
                override fun click(item: DataItem) {
                    val intentSendId = Intent(activity, DetailHistoryActivity::class.java).apply {
                        putExtra(DetailHistoryActivity.GET_ID, item.transactionId)
                        item.returnInstallment.forEach {
                            putExtra(DetailHistoryActivity.GET_STATUS, it.returnStatus)
                        }
                    }
                    startActivity(intentSendId)
                }
            })
        binding.recyclerPortofolio.adapter = adapterPortofolio

        portofolioViewModel.loanResponse.observe(viewLifecycleOwner, {
            adapterPortofolio.update(it)
        })

        portofolioViewModel.balanceResponse.observe(viewLifecycleOwner, {
            binding.totBalanceScreen.text = CurrencyHelper.toIdrCurrency(it.balance)
            binding.totNeedBalanceScreen.text = CurrencyHelper.toIdrCurrency(it.totalFunding)
            binding.totSlashBalanceScreen.text = "/"
            val balance = it.balance
            binding.buttonWithdraw.setOnClickListener {
                if (balance == 0) {
                    binding.buttonWithdraw.setOnClickListener {
                        FirebaseMessaging.getInstance().token
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    if (task.result != null && !TextUtils.isEmpty(task.result)) {
                                        val token: String = task.result!!
                                    }
                                }
                            }
                        val dialogBuilder = AlertDialog.Builder(activity)

                        dialogBuilder.setMessage("You have an insufficient amount of fund")
                            .setTitle("")
                            .setCancelable(false)
                            .setPositiveButton("Ok", { dialog, id ->
                                dialog.dismiss()
                            })

                        val alert = dialogBuilder.create()
                        alert.setTitle("")
                        alert.show()
                    }
                } else {
                    val dialogBuilder = AlertDialog.Builder(activity)

                    dialogBuilder.setMessage("Do you want withdraw all your remaining balance?")
                        .setTitle("")
                        .setCancelable(false)
                        .setPositiveButton("Yes", { dialog, id ->
                            binding.buttonWithdraw.setOnClickListener {
                                portofolioViewModel.withdrawAllFunds()
                                Toast.makeText(activity, "Your balance has succesfully been withdrawn",Toast.LENGTH_SHORT).show()
                            }
                        })
                        .setNegativeButton("No", { dialog, id ->
                            dialog.cancel()
                        })
                    val alert = dialogBuilder.create()
                    alert.setTitle("")
                    alert.show()
                }
            }
        })
        portofolioViewModel.summaryResponse.observe(viewLifecycleOwner, {
            binding.textDummy10jt.text = CurrencyHelper.toIdrCurrency(it.totalWithdrawnThisMonth)
            binding.textDummy7jt.text = CurrencyHelper.toIdrCurrency(it.totalFunding)
            binding.textDummy2jt.text = CurrencyHelper.toIdrCurrency(it.upcomingReturn)
            binding.textDummyStartup.text = "${it.loanTransactionCount} Startup"
        })

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

//class PortofolioFragment : Fragment() {
//    private lateinit var portofolioViewModel: PortofolioViewModel
//    private var _binding: FragmentPortofolioBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        super.onCreate(savedInstanceState)
//        _binding = FragmentPortofolioBinding.inflate(inflater, container, false)
//        portofolioViewModel =
//            ViewModelProvider(this).get(PortofolioViewModel::class.java)
//
//        portofolioViewModel.onViewLoaded()
//
//        portofolioViewModel.balanceResponse.observe(viewLifecycleOwner,{
//            binding.totBalanceScreen.text = CurrencyHelper.toIdrCurrency(it.balance)
//            binding.totNeedBalanceScreen.text = CurrencyHelper.toIdrCurrency(it.totalFunding)
//        })
//
//        portofolioViewModel.summaryResponse.observe(viewLifecycleOwner,{
//            binding.textDummy10jt.text = CurrencyHelper.toIdrCurrency(it.totalWithdrawnThisMonth)
//            binding.textDummy7jt.text = CurrencyHelper.toIdrCurrency(it.totalFunding)
//            binding.textDummy2jt.text = CurrencyHelper.toIdrCurrency(it.upcomingReturn)
//            binding.textDummyStartup.text = "${it.loanTransactionCount} Startup"
//        })
//
//        val adapterPortofolio = AdapterPortofolio(listOf(),
//            object : AdapterPortofolio.EventListener {
//                override fun click(item: DataItem) {
////                        val intentSendId = Intent(activity, DetailHistoryActivity::class.java).apply {
////                            item.returnInstallment.forEach {
////                                putExtra(DetailHistoryActivity.GET_ID, it.id)
////                                putExtra(DetailHistoryActivity.GET_STATUS, it.returnStatus)
////                            }
////                        }
////                    startActivity(intentSendId)
//                }
//            })
//
//        portofolioViewModel.loanResponse.observe(viewLifecycleOwner, {
//            adapterPortofolio.update(it)
//        })
//        binding.recyclerPortofolio.adapter = adapterPortofolio
//
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}