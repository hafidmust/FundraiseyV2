package app.binar.synrgy.android.finalproject.data.profile

import com.google.gson.annotations.SerializedName

data class CitizenIDResponse(
    @SerializedName("filename") var filename: String,
    @SerializedName("name") var name: String,
    @SerializedName("mime") var mime: String,
    @SerializedName("extension") var extension: String,
    @SerializedName("url") var url: String
)
