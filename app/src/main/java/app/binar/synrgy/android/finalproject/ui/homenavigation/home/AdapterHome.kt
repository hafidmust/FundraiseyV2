package app.binar.synrgy.android.finalproject.ui.homenavigation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.home.DataItem
import app.binar.synrgy.android.finalproject.data.home.HomeLoanResponse
import app.binar.synrgy.android.finalproject.databinding.AdapterRecyclerHomeBinding
import com.bumptech.glide.Glide

class AdapterHome(var data : List<DataItem>) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {
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
            binding.textTotalDonation.text  = home.targetValue.toString()
            binding.textDescription.text = home.description
            binding.textAmountColected.text = home.currentValue.toString()

        }
    }
}