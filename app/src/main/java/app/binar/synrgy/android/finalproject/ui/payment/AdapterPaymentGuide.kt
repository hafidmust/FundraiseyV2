package app.binar.synrgy.android.finalproject.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.payment.PaymentGuideResponse
import app.binar.synrgy.android.finalproject.databinding.AdapterPaymentGuideBinding
import com.bumptech.glide.Glide

class AdapterPaymentGuide(var data : List<PaymentGuideResponse>) : RecyclerView.Adapter<AdapterPaymentGuide.ViewHolder>() {

    inner class ViewHolder(val binding : AdapterPaymentGuideBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(guide : PaymentGuideResponse){
            Glide.with(binding.root)
                .load(guide.image)
                .into(binding.imgGuidePayment)
        }
    }
    fun update(data : List<PaymentGuideResponse>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterPaymentGuideBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}