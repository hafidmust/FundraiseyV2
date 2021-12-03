package app.binar.synrgy.android.finalproject.ui.homenavigation.history

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.history.ContentItem
import app.binar.synrgy.android.finalproject.databinding.ItemHistoryBinding
import app.binar.synrgy.android.finalproject.utils.CurrencyHelper

class AdapterHistory(var data: List<ContentItem>, val listener : EventListener) :
    RecyclerView.Adapter<AdapterHistory.ViewHolder>() {
    inner class ViewHolder(val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
            @SuppressLint("ResourceAsColor")
            fun bind(ContentItem: ContentItem){
                binding.tvStartupname.text = ContentItem.loan.name
                binding.tvNominalHistory.text = ContentItem.amount.toString()
                binding.tvDeadline.text = ContentItem.paymentDeadline
                binding.tvContentCampaigndeadline.text = ContentItem.loan.endDate
                binding.textHistoryDate.text = ContentItem.transactionStatus
                binding.textHistoryStartUpName.text = ContentItem.loan.name
                binding.tvNominalHistory.text = CurrencyHelper.toIdrCurrency(ContentItem.amount)

                    when(ContentItem.transactionStatus){
                        "pending" -> binding.textHistoryDate.setBackgroundColor(Color.parseColor("#D99F48"))
                        "Paid off" -> binding.textHistoryDate.setBackgroundColor(Color.parseColor("#3692ED"))
                        "Being Funded" -> binding.textHistoryDate.setBackgroundColor(Color.parseColor("#0F4880"))
                        "Late return" -> binding.textHistoryDate.setBackgroundColor(Color.parseColor("#C62828"))
                        "Has returned" -> binding.textHistoryDate.setBackgroundColor(Color.parseColor("#26800F"))

                    }
                binding.root.setOnClickListener {
                    listener.click(ContentItem)
                }
            }
    }
    fun update(data : List<ContentItem>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemHistoryBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface EventListener{
        fun click(item : ContentItem)
    }

}