package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.constant.Const
import app.binar.synrgy.android.finalproject.databinding.FragmentHomeBinding
import app.binar.synrgy.android.finalproject.ui.signin.SignInActivity
import app.binar.synrgy.android.finalproject.ui.signup.SignupActivity
import app.binar.synrgy.android.finalproject.ui.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val sharedPreferences =
            activity?.getSharedPreferences(
                Const.PREF_NAME,
                AppCompatActivity.MODE_PRIVATE
            )
        homeViewModel = HomeViewModel(sharedPreferences!!)

        binding.btnSignout.setOnClickListener {
            println("logout")
            homeViewModel.logout()
            startActivity(Intent(this.context, SignupActivity::class.java))
        }

//        binding.btnRequireAccess.setOnClickListener {
//            if (sharedPreferences.getBoolean(Const.IS_GUEST, false)) {
//                startActivity(Intent(this.context, SignupActivity::class.java))
//            } else {
//                println("User ini sudah login")
//            }
//        }
        return root
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
}