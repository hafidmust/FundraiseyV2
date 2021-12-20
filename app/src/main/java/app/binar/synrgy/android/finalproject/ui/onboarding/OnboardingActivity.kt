package app.binar.synrgy.android.finalproject.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager2.widget.ViewPager2
import app.binar.synrgy.android.finalproject.R
import com.google.android.material.button.MaterialButton

class OnboardingActivity : AppCompatActivity() {
    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        setOnBoardingItems()
        setupIndicators()
        setCurrentIndicator(0)
        findViewById<TextView>(R.id.tvSkip).setOnClickListener {
            startActivity(Intent(applicationContext, SkippedOnboardingActivity::class.java))
        }
    }

    private fun setOnBoardingItems() {
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OnBoardingItem(
                    R.drawable.onboarding1,
                    "Competitive Return",
                    "Earn high return up to 15% p.a."
                ),
                OnBoardingItem(
                    R.drawable.onboarding2,
                    "Safe And Secure Lending",
                    "Licensed and monitored by OJK"
                ),
                OnBoardingItem(
                    R.drawable.onboarding3,
                    "Fast and Easy Process",
                    "Fund loans anywhere and anytime"
                ),
                )
        )
        val onBoardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
        onBoardingViewPager.adapter = onboardingItemsAdapter
        onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        findViewById<MaterialButton>(R.id.btnNext).setOnClickListener {
            if (onBoardingViewPager.currentItem + 1 < onboardingItemsAdapter.itemCount) {
                onBoardingViewPager.currentItem += 1
            } else {
                navigateToSkippedOnboarding()
            }
        }
    }

    private fun setupIndicators() {
        indicatorsContainer = findViewById(R.id.indicatorContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].let {
                it?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.indicator_inactive_bg)
                )
                it?.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }

        }
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_bg
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_bg
                    )
                )
            }
        }
    }

    private fun navigateToSkippedOnboarding() {
        startActivity(Intent(applicationContext, SkippedOnboardingActivity::class.java))
    }
}