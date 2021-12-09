package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.data.home.DataItem
import app.binar.synrgy.android.finalproject.databinding.FragmentHomeBinding

import app.binar.synrgy.android.finalproject.ui.loan.LoanDetailsActivity

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val homeAdapter = AdapterHome(listOf(), object : AdapterHome.EventListener{
            override fun click(item: DataItem) {
                val intentSendId = Intent(activity, LoanDetailsActivity::class.java).apply {
                    putExtra(LoanDetailsActivity.GET_ID, item.id)
                }
                startActivity(intentSendId)

            }
        } )

        binding.recyclerHome.adapter = homeAdapter
        homeViewModel.onViewLoaded()
        homeViewModel.homeResponse.observe(viewLifecycleOwner, {
            homeAdapter.update(it)
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}