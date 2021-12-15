package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.data.portofolio.DataItem
import app.binar.synrgy.android.finalproject.databinding.FragmentPortofolioBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail.DetailHistoryActivity
import app.binar.synrgy.android.finalproject.utils.CurrencyHelper


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
        })

        portofolioViewModel.summaryResponse.observe(viewLifecycleOwner, {
            binding.textDummy10jt.text = CurrencyHelper.toIdrCurrency(it.totalWithdrawnThisMonth)
            binding.textDummy7jt.text = CurrencyHelper.toIdrCurrency(it.totalFunding)
            binding.textDummy2jt.text = CurrencyHelper.toIdrCurrency(it.upcomingReturn)
            binding.textDummyStartup.text = "${it.loanTransactionCount} Startup"
        })

        binding.buttonWithdraw.setOnClickListener {
            portofolioViewModel.withdrawAllFunds()
        }

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