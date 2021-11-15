package app.binar.synrgy.android.finalproject.ui.onboarding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import app.binar.synrgy.android.finalproject.R;
import app.binar.synrgy.android.finalproject.constant.Const;
import app.binar.synrgy.android.finalproject.ui.homenavigation.HomeNavigationActivity;
import app.binar.synrgy.android.finalproject.ui.signin.SignInActivity;
import app.binar.synrgy.android.finalproject.ui.signup.SignupActivity;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    // Number of pages that wanted to be shown
    @Override
    public int getCount() {
        return 4;
    }

    // Converting a View into an object
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_screen, container, false);

        ImageView logo = (ImageView) view.findViewById(R.id.logo);


        ImageView ind1 = (ImageView) view.findViewById(R.id.indicator1);
        ImageView ind2 = (ImageView) view.findViewById(R.id.indicator2);
        ImageView ind3 = (ImageView) view.findViewById(R.id.indicator3);
        ImageView ind4 = (ImageView) view.findViewById(R.id.indicator4);
        ImageView back = (ImageView) view.findViewById(R.id.back);

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView desc = (TextView) view.findViewById(R.id.desc);
        TextView skip = (TextView) view.findViewById(R.id.skip);

        Button next = (Button) view.findViewById(R.id.next);
        Button login = (Button) view.findViewById(R.id.login);
        Button register = (Button) view.findViewById(R.id.signup);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position + 1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position - 1);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(4);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, SignInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, SignupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });

        switch (position) {
            case 0:
                logo.setImageResource(R.drawable.onboarding1);
                ind1.setImageResource(R.drawable.selected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);

                title.setText(R.string.onboarding1);
                desc.setText(R.string.desc1);
                back.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                break;

            case 1:
                logo.setImageResource(R.drawable.onboarding2);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.selected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);

                title.setText(R.string.onboarding2);
                desc.setText(R.string.desc2);
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                break;

            case 2:
                logo.setImageResource(R.drawable.onboarding3);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.selected);
                ind4.setImageResource(R.drawable.unselected);

                title.setText(R.string.onboarding3);
                desc.setText(R.string.desc3);
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                break;

            case 3:
                logo.setImageResource(R.drawable.onboarding4);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.selected);

                title.setText(R.string.onboarding4);
                desc.setText(R.string.desc4);
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.GONE);
                login.setVisibility(View.VISIBLE);
                register.setVisibility(View.VISIBLE);
                skip.setText(R.string.guest_login);
                skip.setVisibility(View.VISIBLE);
                skip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editor.putBoolean(Const.IS_GUEST, true);
                        editor.putBoolean(Const.IS_LOGIN, true);
                        Intent intent = new Intent(ctx, HomeNavigationActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        ctx.startActivity(intent);
                    }
                });
                break;
        }


        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
