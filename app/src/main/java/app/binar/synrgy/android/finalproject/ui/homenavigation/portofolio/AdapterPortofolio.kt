package app.binar.synrgy.android.finalproject.ui.homenavigation.portofolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.portofolio.Data
import app.binar.synrgy.android.finalproject.data.portofolio.DataItem
import app.binar.synrgy.android.finalproject.databinding.AdapterRecyclerPortofolioBinding
import app.binar.synrgy.android.finalproject.utils.DaysHelper

class AdapterPortofolio(
    var data: List<DataItem>,
    val listener: EventListener,
    ) : RecyclerView.Adapter<AdapterPortofolio.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterRecyclerPortofolioBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(portofolioLoan: DataItem) {
            binding.textStartUpName.text = portofolioLoan.startupName
            binding.textProjectFunding.text = portofolioLoan.loanName
            binding.textTotalAmount.text = portofolioLoan.currentLoanValue.toString()
            binding.textTotalTarget.text = portofolioLoan.targetLoanValue.toString()
            binding.textPaymentDeadline.text = DaysHelper.dateReverse(portofolioLoan.endDate)
            portofolioLoan.returnInstallment.forEach {
                binding.textStatusPayment.text = it.returnStatus
            }
            binding.root.setOnClickListener {
                listener.click(portofolioLoan)
            }
        }

//        @SuppressLint("ResourceAsColor")
//        fun bind(portofolioResponseDummy: PortofolioResponseDummy){
//            binding.textHistoryStartUpName.text = portofolioResponseDummy.namaStartup
//            binding.textHistoryTotalAmount.text = portofolioResponseDummy.nominalDonasi
//            binding.textHistoryDate.text = portofolioResponseDummy.campaignDeadline
//            binding.textHistoryStatusPayment.text = portofolioResponseDummy.statusPayment
//            binding.textHistoryTotalTarget.text = portofolioResponseDummy.totalDonasi
//
//            when(portofolioResponseDummy.statusPayment){
//                "Payment process" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#D99F48"))
//                "Paid off" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#3692ED"))
//                "Being Funded" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#0F4880"))
//                "Late return" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#C62828"))
//                "Has returned" -> binding.textHistoryStatusPayment.setBackgroundColor(Color.parseColor("#26800F"))
//
//            }
//            binding.root.setOnClickListener {
//                listener.click(portofolioResponseDummy)
//            }
//        }
    }

    interface EventListener {
        fun click(item: DataItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPortofolio.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRecyclerPortofolioBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    fun update(data: List<DataItem>) {
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
