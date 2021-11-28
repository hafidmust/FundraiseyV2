package app.binar.synrgy.android.finalproject.ui.homenavigation.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.R

class InformationFragment : Fragment() {
    companion object {
        fun newInstance() = InformationFragment()
    }

    private lateinit var viewModel: InformationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InformationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}