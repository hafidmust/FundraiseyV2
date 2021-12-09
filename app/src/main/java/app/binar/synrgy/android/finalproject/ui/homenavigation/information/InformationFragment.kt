package app.binar.synrgy.android.finalproject.ui.homenavigation.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.binar.synrgy.android.finalproject.databinding.FragmentInformationBinding
import android.content.Intent
import android.net.Uri
import app.binar.synrgy.android.finalproject.data.information.InformationResponse


class InformationFragment : Fragment() {
    private lateinit var viewModel: InformationViewModel
    private lateinit var binding: FragmentInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationBinding.inflate(inflater, container, false)
        viewModel = InformationViewModel()

        val root: View = binding.root
        val informationAdapter = AdapterInformation(listOf(),
            object : AdapterInformation.EventListener {
                override fun click(item: InformationResponse) {
                }
            }
        )
        val informationAdapter2 = AdapterInformation(listOf(),
            object : AdapterInformation.EventListener {
                override fun click(item: InformationResponse) {
                }
            }
        )
        binding.recyclerFaq1.adapter = informationAdapter
        binding.recyclerFaq2.adapter = informationAdapter2
        binding.buttonContactFaq.setOnClickListener {
            val number = "+62 82362035167"
            val url = "https://api.whatsapp.com/send?phone=$number"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        viewModel.onViewLoaded()
        viewModel.responseFAQ1.observe(viewLifecycleOwner, {
            informationAdapter.update(it)
        })
        viewModel.responseFAQ2.observe(viewLifecycleOwner, {
            informationAdapter2.update(it)
        })

        return root
    }
}
