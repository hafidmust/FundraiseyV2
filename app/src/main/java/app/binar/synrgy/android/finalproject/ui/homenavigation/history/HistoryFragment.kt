package app.binar.synrgy.android.finalproject.ui.homenavigation.history

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.binar.synrgy.android.finalproject.constant.Constant
import app.binar.synrgy.android.finalproject.data.history.ContentItem
import app.binar.synrgy.android.finalproject.data.local.AppDatabase
import app.binar.synrgy.android.finalproject.databinding.FragmentHistoryBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail.DetailHistoryActivity

class HistoryFragment : Fragment() {
    private lateinit var binding : FragmentHistoryBinding
    private lateinit var viewModel : HistoryViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val appDatabase = AppDatabase.getInstance(requireContext())
        val sharedPreferences = activity?.getSharedPreferences(Constant.PREF_NAME, Context.MODE_PRIVATE)
        viewModel = HistoryViewModel(appDatabase,sharedPreferences)
        val historyAdapter = AdapterHistory(listOf(),
        object : AdapterHistory.EventListener {
            override fun click(item: ContentItem) {
                val intentSendId = Intent(activity, DetailHistoryActivity::class.java).apply {
                    putExtra(DetailHistoryActivity.GET_ID, item.id)
                    putExtra(DetailHistoryActivity.GET_STATUS, item.transactionStatus)
                }
                startActivity(intentSendId)
            }
        })
        binding.shimmerHistory.startShimmerAnimation()
        binding.recyclerviewHistory.adapter = historyAdapter
        viewModel.onViewLoaded()
        viewModel.history.observe(viewLifecycleOwner,{
            binding.shimmerHistory.stopShimmerAnimation()
            binding.shimmerHistory.visibility = View.GONE

            historyAdapter.update(it)
        })

        val root : View = binding.root
        return root
    }

}