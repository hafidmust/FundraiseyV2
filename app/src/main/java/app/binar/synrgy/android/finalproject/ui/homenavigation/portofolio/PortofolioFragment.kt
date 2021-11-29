package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.data.portofolio.loan
import app.binar.synrgy.android.finalproject.databinding.FragmentPortofolioBinding
import app.binar.synrgy.android.finalproject.model.PortofolioModel


class PortofolioFragment : Fragment() {
    private lateinit var portofolioViewModel: PortofolioViewModel
    private var _binding: FragmentPortofolioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = binding.root
        val adapterPortofolio = AdapterPortofolio(listOf(),
            object : AdapterPortofolio.EventListener {
                override fun click(item: loan) {
                }
            })

        portofolioViewModel =
            ViewModelProvider(this).get(PortofolioViewModel::class.java)
        binding.recyclerPortofolio.adapter = adapterPortofolio
        _binding = FragmentPortofolioBinding.inflate(inflater, container, false)

        portofolioViewModel.onViewLoaded()
        portofolioViewModel.loanResponse.observe(viewLifecycleOwner, {
            adapterPortofolio.update(it)
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}