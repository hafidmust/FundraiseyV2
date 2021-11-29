package app.binar.synrgy.android.finalproject.ui.homenavigation.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.databinding.FragmentHomeBinding
import app.binar.synrgy.android.finalproject.databinding.FragmentInformationBinding
import android.content.Intent
import android.net.Uri


class InformationFragment : Fragment() {
    private lateinit var informationViewModel: InformationViewModel
    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )
    : View? {
        informationViewModel =
            ViewModelProvider(this).get(InformationViewModel::class.java)

        _binding = FragmentInformationBinding.inflate(inflater, container, false)

        val root: View = binding.root
        binding.buttonContactFaq.setOnClickListener {
            val number = "+62 82362035167"
            val url = "https://api.whatsapp.com/send?phone=$number"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        return root
    }
}
