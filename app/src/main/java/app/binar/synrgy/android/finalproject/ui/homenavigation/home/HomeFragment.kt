package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.constant.Const
import app.binar.synrgy.android.finalproject.databinding.FragmentHomeBinding
import app.binar.synrgy.android.finalproject.ui.signin.SignInActivity
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val sharedPreferences = activity?.getSharedPreferences(
                Const.PREF_NAME,
                AppCompatActivity.MODE_PRIVATE)

        binding.btnSignout.setOnClickListener {
            homeViewModel.logout()
        }

        binding.btnRequireAccess.setOnClickListener {
            if (sharedPreferences != null) {
                if (sharedPreferences.getBoolean(Const.IS_GUEST, true)){
                    startActivity(Intent(this.context, SignInActivity::class.java))
                } else {
                    print("User ini sudah login")
                }
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}