package app.binar.synrgy.android.finalproject.ui.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.binar.synrgy.android.finalproject.R

class OnboardingItemsAdapter(private val onBoardingItem: List<OnBoardingItem>) :
RecyclerView.Adapter<OnboardingItemsAdapter.OnboardingItemViewHolder>() {
    inner class OnboardingItemViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val imgOnboarding = view.findViewById<ImageView>(R.id.imageOnboarding)
        private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        private val tvDescription = view.findViewById<TextView>(R.id.tvDescription)

        fun bind(onboardingItem : OnBoardingItem){
            imgOnboarding.setImageResource(onboardingItem.image)
            tvTitle.text = onboardingItem.title
            tvDescription.text = onboardingItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_item_container, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onBoardingItem[position])
    }

    override fun getItemCount(): Int {
        return onBoardingItem.size
    }
}