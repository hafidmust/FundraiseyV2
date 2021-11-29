package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.home.DataItem
import app.binar.synrgy.android.finalproject.databinding.AdapterRecyclerHomeBinding
import java.util.*


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
        fun bind(home : DataItem){
            binding.textStartUpTitle.text = home.name
            binding.textTotalDonation.text  = "Rp. " + home.targetValue.toString()
            binding.textDescription.text = home.description
            binding.textAmountColected.text = "Rp. " + home.currentValue.toString()
            binding.root.setOnClickListener {
                listener.click(home)
            }
        }
    }
}