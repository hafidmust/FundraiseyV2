package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.home.DataItem
import app.binar.synrgy.android.finalproject.databinding.AdapterRecyclerHomeBinding
import app.binar.synrgy.android.finalproject.utils.DaysHelper
import java.text.NumberFormat
import java.util.*
import org.joda.time.Days
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit


class AdapterHome(var data : List<DataItem>, val listener : EventListener) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {
    interface EventListener{
        fun click(item: DataItem)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHome.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRecyclerHomeBinding.inflate(inflater)
        return ViewHolder(binding)
    }
    fun update(data : List<DataItem>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdapterHome.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
    inner class ViewHolder(val binding : AdapterRecyclerHomeBinding) : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n", "SimpleDateFormat")
        fun bind(home : DataItem){
            binding.textStartUpTitle.text = home.startupName
            binding.textProjectfunding.text = home.name

            val format: NumberFormat = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 0
            format.currency = Currency.getInstance("IDR")

            binding.textTotalDonation.text  = "${format.format(home.targetValue)}"
            binding.textDescription.text = home.description
            binding.textAmountColected.text = "${format.format(home.currentValue)}"
            binding.indicatorAdapter.max = home.targetValue!!
            binding.indicatorAdapter.progress = home.currentValue!!
//            val startdate = SimpleDateFormat("dd-MM-yyyy").parse(home.startDate)
//            val endDate = SimpleDateFormat("dd-MM-yyyy").parse(home.endDate)
//            val getDays = endDate.time - startdate.time
//            val remainingDays = TimeUnit.DAYS.convert(getDays, TimeUnit.MILLISECONDS)
            val remainingDays = DaysHelper.getDaysHelper(home.startDate.toString(),home.endDate.toString())
            binding.textDeadlineDate.text = "$remainingDays day"

            binding.root.setOnClickListener {
                listener.click(home)
            }
        }
    }
}