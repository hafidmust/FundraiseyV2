package app.binar.synrgy.android.finalproject.ui.profile.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.databinding.ActivityProfileScreenBinding

class ProfileFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileScreenBinding
    private lateinit var viewModel: ProfileFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this).get(ProfileFormViewModel::class.java)
        viewModel.getUserData()
        viewModel.profileResponse.observe(this, {
            binding.editEmail.setText(it.email)
            binding.editIdNum.setText(it.citizenID)
            binding.editFullName.setText(it.fullName)
            binding.editBank.setText(it.bankAccountNumber)
            binding.editPhone.setText(it.phoneNumber)
            binding.editBirthProfile.setText(it.dateOfBirth)
            when(it.gender){
                "male" -> binding.genderRadio.setSelection(2)
                "female" -> binding.genderRadio.setSelection(1)
            }
        })
    }
}