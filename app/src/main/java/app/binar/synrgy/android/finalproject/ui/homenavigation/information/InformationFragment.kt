package app.binar.synrgy.android.finalproject.ui.homenavigation.information

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.binar.synrgy.android.finalproject.databinding.FragmentInformationBinding
import android.content.Intent
import android.net.Uri
import app.binar.synrgy.android.finalproject.R
import app.binar.synrgy.android.finalproject.data.information.InformationResponse
import app.binar.synrgy.android.finalproject.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.fragment_home.*


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

            val dialogBuilder = AlertDialog.Builder(activity)

            dialogBuilder.setMessage("This action will take you to our Whatsapp Contact, continue?")
                .setCancelable(false)
                .setPositiveButton("Proceed", { dialog, id ->
                    val number = "+62 85800605688"
                    val url = "https://api.whatsapp.com/send?phone=$number"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                })
                .setNegativeButton("Stay Here", {
                        dialog, id -> dialog.dismiss()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("")
            alert.setIcon(R.drawable.ic_union)
            alert.show()
        }

        binding.logoProfile.setOnClickListener {
            val intentSendId = Intent(activity, ProfileActivity::class.java).apply {
            }
            startActivity(intentSendId)
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
