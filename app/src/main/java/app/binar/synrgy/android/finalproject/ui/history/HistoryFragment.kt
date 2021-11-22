package app.binar.synrgy.android.finalproject.ui.history

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import app.binar.synrgy.android.finalproject.data.history.HistoryResponseDummy
import app.binar.synrgy.android.finalproject.databinding.FragmentHistoryBinding
import app.binar.synrgy.android.finalproject.ui.history.detail.DetailHistoryActivity


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
        object : AdapterHistory.EventListener{
            override fun click(item: HistoryResponseDummy) {
                startActivity(Intent(this@HistoryFragment.context,DetailHistoryActivity::class.java))
            }
        })
        binding.recyclerviewHistory.adapter = historyAdapter
        viewModel.onViewLoaded()
        viewModel.responseDummy.observe(viewLifecycleOwner,{
            historyAdapter.update(it)
        })
        val root : View = binding.root
        return root
    }

}