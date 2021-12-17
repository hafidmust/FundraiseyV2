package app.binar.synrgy.android.finalproject.ui.homenavigation.information

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.binar.synrgy.android.finalproject.data.information.InformationResponse

class InformationViewModel : ViewModel() {
    val responseFAQ1: MutableLiveData<List<InformationResponse>> = MutableLiveData()
    val responseFAQ2: MutableLiveData<List<InformationResponse>> = MutableLiveData()

    val faq1 = listOf(
        InformationResponse(
            question = "How does FundRaisey work?",
            answer = "FundRaisey is a marketplace that is a space for borrowers and lenders to help each other. Our job is to make sure the borrowers funds are valid and eligible to be given a loan from the lender. Lenders will benefit when the borrower has benefited from the project they submitted at the beginning of the loan with a loan period of 2 years",
        ),
        InformationResponse(
            question = "Benefits of using FundRaisey",
            answer = "There are many benefits that you can get with one app.\n" +
                    "\n" +
                    "    Benefit of Borrower:\n" +
                    "    • Competitive loan interest\n" +
                    "    • An easy and simple process\n" +
                    "    • Product promotion of the application\n" +
                    "\n" +
                    "    Benefit of Lender :\n" +
                    "    • Interesting yields\n" +
                    "    • Easy and simple investment process\n" +
                    "    • Can choose your own startup you want to fund\n" +
                    "    • Customer support that is always ready to serve"
        ),
        InformationResponse(
            question = "Type of FundRaisey Lending",
            answer = "FundRaisey is a P2P Lending platform, which has a business focus on financing businesses for the startup segment with digital products. which brings together startup owners (Borrowers) and Investors (Lenders).\n" +
                    "\n" +
                    "Peer-to-peer Lending (P2P Lending) is bringing together people who want to fund and people who want to apply for lending through online platforms."
        )
    )

    val faq2 = listOf(
        InformationResponse(
            question = "How to become a borrower in FundRaisey",
            answer = "If you want to borrow funding from FundRaisey, you can register your startup on our website or go to profile and choose to register as a borrower.\n",
        ),
        InformationResponse(
            question = "What are the requirements to become a lender at FundRaisey",
            answer = "To become a lender you only have to be over 18 years old and already have an ID card. And for those of you who are very interested in investment we very welcome you"
        ),
    )

    fun onViewLoaded() {
        responseFAQ1.value = faq1
        responseFAQ2.value = faq2
    }
}