package app.binar.synrgy.android.finalproject.data.information

data class InformationResponse(
    val question: String,
    val answer: String,
    var expandable: Boolean = false
)