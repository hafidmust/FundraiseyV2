package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.data.home.homeDataItem
import app.binar.synrgy.android.finalproject.databinding.FragmentHomeBinding
import app.binar.synrgy.android.finalproject.ui.loan.LoanDetailsActivity
import app.binar.synrgy.android.finalproject.ui.profile.ProfileActivity
import app.binar.synrgy.android.finalproject.utils.Const
import app.binar.synrgy.android.finalproject.utils.CurrencyHelper

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.logoProfile.setOnClickListener {
            val intentSendId = Intent(activity, ProfileActivity::class.java).apply {
            }
            startActivity(intentSendId)
        }

        val sharedPreferences = requireActivity().getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)
        val root: View = binding.root
        val homeAdapter = AdapterHome(listOf(), object : AdapterHome.EventListener{
            override fun click(item: homeDataItem) {
                val intentSendId = Intent(activity, LoanDetailsActivity::class.java).apply {
                    putExtra(LoanDetailsActivity.GET_ID, item.id)
                    sharedPreferences.edit {
                        this.putInt(Const.FUNDING_ID, item.id!!)
                    }
                }
                startActivity(intentSendId)
            }
        } )

        binding.recyclerHome.adapter = homeAdapter
        homeViewModel.onViewLoaded()
        homeViewModel.getDataBalance()
        homeViewModel.homeResponse.observe(viewLifecycleOwner, {
            homeAdapter.update(it)
        })
        homeViewModel.balanceResponse.observe(viewLifecycleOwner,{
            binding.amountBalance.text = CurrencyHelper.toIdrCurrency(it.balance)
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}