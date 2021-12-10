package app.binar.synrgy.android.finalproject.ui.homenavigation.history

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.binar.synrgy.android.finalproject.data.history.ContentItem
import app.binar.synrgy.android.finalproject.data.history.HistoryResponseDummy
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
        viewModel = HistoryViewModel()
        val historyAdapter = AdapterHistory(listOf(),
        object : AdapterHistory.EventListener {
            override fun click(item: ContentItem) {
                val intentSendId = Intent(activity, DetailHistoryActivity::class.java).apply {
                    putExtra(DetailHistoryActivity.GET_ID, item.id)
                }
                startActivity(intentSendId)
            }
        })
        binding.recyclerviewHistory.adapter = historyAdapter
        viewModel.onViewLoaded()
        viewModel.history.observe(viewLifecycleOwner,{
            historyAdapter.update(it)
        })
        val root : View = binding.root
        return root
    }

}