package app.binar.synrgy.android.finalproject.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.history.HistoryResponseDummy
import app.binar.synrgy.android.finalproject.databinding.AdapterRecyclerHistoryBinding
import app.binar.synrgy.android.finalproject.databinding.ItemHistoryBinding

class AdapterHistory(var data: List<HistoryResponseDummy>, val listener : EventListener) :
    RecyclerView.Adapter<AdapterHistory.ViewHolder>() {
    inner class ViewHolder(val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(historyResponseDummy: HistoryResponseDummy){
                binding.tvStartupname.text = historyResponseDummy.namaStartup
                binding.tvNominalHistory.text = historyResponseDummy.nominalDonasi
                binding.tvDeadline.text = historyResponseDummy.paymentDeadline
                binding.tvContentCampaigndeadline.text = historyResponseDummy.campaignDeadline

                binding.root.setOnClickListener {
                    listener.click(historyResponseDummy)
                }
            }
    }
    fun update(data : List<HistoryResponseDummy>){
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
        fun click(item : HistoryResponseDummy)
    }

}