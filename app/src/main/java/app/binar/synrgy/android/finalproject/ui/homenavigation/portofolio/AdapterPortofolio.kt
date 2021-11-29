package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.history.HistoryResponseDummy
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponse
import app.binar.synrgy.android.finalproject.data.portofolio.PortofolioResponseDummy
import app.binar.synrgy.android.finalproject.data.portofolio.loan
import app.binar.synrgy.android.finalproject.data.portofolio.returnInstallment
import app.binar.synrgy.android.finalproject.databinding.AdapterRecyclerPortofolioBinding
import app.binar.synrgy.android.finalproject.model.PortofolioModel

class AdapterPortofolio(
    var data: List<PortofolioResponseDummy>,
    val listener: EventListener
) : RecyclerView.Adapter<AdapterPortofolio.ViewHolder>() {
    inner class ViewHolder(val binding: AdapterRecyclerPortofolioBinding) :
        RecyclerView.ViewHolder(binding.root) {
//        fun bind(portofolioLoan: loan) {
//            binding.textHistoryStartUpName.text = portofolioLoan.name
//            binding.textHistoryTotalTarget.text = portofolioLoan.targetValue.toString()
////            binding.textHistoryStatusPayment.text = portofolioData.returnStatus
////            binding.textHistoryTotalAmount.text = portofolioData.amount.toString()
////            binding.textHistoryDate.text = portofolioData.returnDate.toString()
////            binding.indicatorPortofolio.progress = progress(portofolioData.amount, portofolioLoan.targetValue)
//            binding.root.setOnClickListener {
//                listener.click(portofolioLoan)
//            }
//        }
        @SuppressLint("ResourceAsColor")
        fun bind(portofolioResponseDummy: PortofolioResponseDummy){
            binding.textHistoryStartUpName.text = portofolioResponseDummy.namaStartup
            binding.textHistoryTotalAmount.text = portofolioResponseDummy.nominalDonasi
            binding.textHistoryDate.text = portofolioResponseDummy.campaignDeadline
            binding.textHistoryStatusPayment.text = portofolioResponseDummy.statusPayment
            binding.textHistoryTotalTarget.text = portofolioResponseDummy.totalDonasi

            when(portofolioResponseDummy.statusPayment){
                "Payment process" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#D99F48"))
                "Paid off" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#3692ED"))
                "Being Funded" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#0F4880"))
                "Late return" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#C62828"))
                "Has returned" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#26800F"))

            }
            binding.root.setOnClickListener {
                listener.click(portofolioResponseDummy)
            }
        }
    }

    interface EventListener {
        fun click(item: PortofolioResponseDummy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPortofolio.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRecyclerPortofolioBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    fun update(data: List<PortofolioResponseDummy>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdapterPortofolio.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

//private fun progress(targetValue: Int?, amount: Int?): Int {
//    return amount!!.div(targetValue!!).times(10)
//}
