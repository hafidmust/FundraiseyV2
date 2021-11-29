package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponse
import app.binar.synrgy.android.finalproject.data.portofolio.loan
import app.binar.synrgy.android.finalproject.data.portofolio.returnInstallment
import app.binar.synrgy.android.finalproject.databinding.AdapterRecyclerPortofolioBinding
import app.binar.synrgy.android.finalproject.model.PortofolioModel

class AdapterPortofolio(
    var dataLoan: List<loan>,
    val listener: EventListener
) : RecyclerView.Adapter<AdapterPortofolio.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterRecyclerPortofolioBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(portofolioLoan: loan) {
            binding.textHistoryStartUpName.text = portofolioLoan.name
            binding.textHistoryTotalTarget.text = portofolioLoan.targetValue.toString()
//            binding.textHistoryStatusPayment.text = portofolioData.returnStatus
//            binding.textHistoryTotalAmount.text = portofolioData.amount.toString()
//            binding.textHistoryDate.text = portofolioData.returnDate.toString()
//            binding.indicatorPortofolio.progress = progress(portofolioData.amount, portofolioLoan.targetValue)
            binding.root.setOnClickListener {
                listener.click(portofolioLoan)
            }
        }
    }

    interface EventListener {
        fun click(item: loan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPortofolio.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRecyclerPortofolioBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    fun update(loandata: List<loan>) {
        this.dataLoan = loandata
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdapterPortofolio.ViewHolder, position: Int) {
        holder.bind(dataLoan[position])
    }

    override fun getItemCount(): Int {
        return dataLoan.size
    }

}

//private fun progress(targetValue: Int?, amount: Int?): Int {
//    return amount!!.div(targetValue!!).times(10)
//}
