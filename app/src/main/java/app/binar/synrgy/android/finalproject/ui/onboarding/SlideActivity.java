package app.binar.synrgy.android.finalproject.ui.onboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import app.binar.synrgy.android.finalproject.R;
import app.binar.synrgy.android.finalproject.databinding.ActivitySlideBinding;
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SlideActivity extends AppCompatActivity {

    public static ViewPager viewPager;
    SlideViewPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        viewPager = findViewById(R.id.viewpager);
        adapter = new SlideViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        SharedPreferences.Editor editor = getSharedPreferences("slide", MODE_PRIVATE).edit();
        editor.putBoolean("slide", true);
        editor.commit();


////        if (AppHasOpened())
////        {
////            Intent intent=new Intent(SlideActivity.this, MainActivity.class);
////            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
////            startActivity(intent);
////        }
////        else
////        {
//            SharedPreferences.Editor editor=getSharedPreferences("slide",MODE_PRIVATE).edit();
//            editor.putBoolean("slide",true);
//            editor.commit();
////        }
    }

//    private boolean AppHasOpened() {
//
//        SharedPreferences sharedPreferences=getSharedPreferences("slide",MODE_PRIVATE);
//        boolean result=sharedPreferences.getBoolean("slide",false);
//        return result;
//
//    }
}
