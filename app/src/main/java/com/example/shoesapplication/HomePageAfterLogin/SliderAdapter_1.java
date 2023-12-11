package com.example.shoesapplication.HomePageAfterLogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.shoesapplication.R;

import java.util.List;

public class SliderAdapter_1 extends PagerAdapter {

    public SliderAdapter_1(List<PhotoSlider_1> mPhoto) {
        this.mPhoto = mPhoto;
    }

    List<PhotoSlider_1> mPhoto;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.custom_slider_layout, container, false);
        ImageView mImgView = view.findViewById(R.id.slide_img);

        PhotoSlider_1 photo = mPhoto.get(position);
        mImgView.setImageResource(photo.getResID());

        container.addView(view);


        return view;
    }

    @Override
    public int getCount() {
        if (mPhoto != null)
        {
            return mPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
