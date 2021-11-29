package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponseDummy
import app.binar.synrgy.android.finalproject.databinding.FragmentPortofolioBinding
import app.binar.synrgy.android.finalproject.ui.homenavigation.history.detail.DetailHistoryActivity


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

        val adapterPortofolio = AdapterPortofolio(listOf(),
            object : AdapterPortofolio.EventListener {
                override fun click(item: PortofolioResponseDummy) {
                    startActivity(Intent(this@PortofolioFragment.context, DetailHistoryActivity::class.java))
                }
            })
        binding.recyclerPortofolio.adapter = adapterPortofolio
        portofolioViewModel.onViewLoaded()
        portofolioViewModel.responseDummy.observe(viewLifecycleOwner, {
            adapterPortofolio.update(it)
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}