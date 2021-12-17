package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.home.homeDataItem
import app.binar.synrgy.android.finalproject.databinding.AdapterRecyclerHomeBinding
import app.binar.synrgy.android.finalproject.utils.DaysHelper
import com.bumptech.glide.Glide
import java.text.NumberFormat
import java.util.*


class AdapterHome(var data : List<homeDataItem>, val listener : EventListener) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {
    interface EventListener{
        fun click(item: homeDataItem)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHome.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRecyclerHomeBinding.inflate(inflater)
        return ViewHolder(binding)
    }
    fun update(data : List<homeDataItem>){
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
        fun bind(home : homeDataItem){
            Glide.with(binding.root)
                .load(home.startup?.logo)
                .into(binding.imageViewStartup)
            binding.textStartUpTitle.text = home.startup?.name.toString()
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