package app.binar.synrgy.android.finalproject.ui.profile.form

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import app.binar.synrgy.android.finalproject.databinding.ActivityProfileScreenBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class ProfileFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileScreenBinding
    private lateinit var viewModel: ProfileFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val getContent =
            registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
                uri?.let {

                    val type = contentResolver.getType(it)
                    val tempFile = File.createTempFile("temp-", null, null)
                    val inputstream = contentResolver.openInputStream(uri)

                    tempFile.outputStream().use {
                        inputstream?.copyTo(it)
                    }

                    val requestBody = tempFile.asRequestBody(type?.toMediaType())
                    val body =
                        MultipartBody.Part.createFormData("image", tempFile.name, requestBody)

                    viewModel.postCitizenID(body)
                    Glide.with(this).load(uri).into(binding.uploadPhotoSectionId)
                }
            }

        binding.uploadPhotoSectionId.setOnClickListener {
            getContent.launch("image/*")
        }

        val getContentSelfie =
            registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
                uri?.let {

                    val type = contentResolver.getType(it)
                    val tempFile = File.createTempFile("temp-", null, null)
                    val inputstream = contentResolver.openInputStream(uri)

                    tempFile.outputStream().use {
                        inputstream?.copyTo(it)
                    }

                    val requestBody = tempFile.asRequestBody(type?.toMediaType())
                    val body =
                        MultipartBody.Part.createFormData("image", tempFile.name, requestBody)

                    viewModel.postSelfie(body)
                    Glide.with(this).load(uri).into(binding.uploadPhotoSectionSelfie)
                }
            }

        binding.uploadPhotoSectionSelfie.setOnClickListener {
            getContentSelfie.launch("image/*")
        }

        binding.buttonSave.setOnClickListener {
            viewModel.updateProfile()
        }

        binding.arrowBack.setOnClickListener {
            onBackPressed()
        }

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
                "male" -> {
                    binding.genderRadio.setSelection(2)
                }
                "female" -> {
                    binding.genderRadio.setSelection(1)
                }
            }
            viewModel.onChangeDOB(it.dateOfBirth)
            viewModel.onChangeGender(binding.genderRadio.selectedItem.toString())
            viewModel.onChangeCitizenID(binding.editIdNum.text.toString())
            viewModel.onChangeFullName(binding.editFullName.text.toString())
            viewModel.onChangeBankAccount(binding.editBank.text.toString())
            viewModel.onChangePhoneNumber(binding.editPhone.text.toString())
        })
    }
    }
