package app.binar.synrgy.android.finalproject.ui.homenavigation.information

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.data.information.InformationResponse
import app.binar.synrgy.android.finalproject.databinding.AdapterInformationBinding

class AdapterInformation(
    var data: List<InformationResponse>,
    val listener: EventListener
) : RecyclerView.Adapter<AdapterInformation.ViewHolder>() {
    lateinit var layout: RelativeLayout
    inner class ViewHolder(val binding: AdapterInformationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(informationResponse: InformationResponse) {
            layout = binding.expandableLayout
            binding.textQuestion.text = informationResponse.question
            binding.textAnswer.text = informationResponse.answer
            binding.root.setOnClickListener {
                listener.click(informationResponse)
            }
        }
    }

    interface EventListener {
        fun click(item: InformationResponse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(AdapterInformationBinding.inflate(inflater))
    }

    fun update(data: List<InformationResponse>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])

        val isExpandable : Boolean = data[position].expandable
        holder.binding.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE
        holder.binding.layoutInformationAdapter.setOnClickListener {
            val toggle = data[position]
            toggle.expandable = !toggle.expandable
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}