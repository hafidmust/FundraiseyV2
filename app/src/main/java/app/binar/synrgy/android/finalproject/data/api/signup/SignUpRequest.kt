package app.binar.synrgy.android.finalproject.data.api.signup

import com.google.gson.annotations.SerializedName

data class SignUpRequest(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("fullName")
	val fullName: String? = null,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("citizenID")
	val citizenID: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
