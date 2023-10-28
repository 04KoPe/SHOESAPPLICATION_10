package com.example.shoesapplicationnew;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;
import java.util.zip.Inflater;

public class SliderAdapter extends PagerAdapter {

    public SliderAdapter(List<PhotoSlider> mPhoto) {
        this.mPhoto = mPhoto;
    }

    List<PhotoSlider> mPhoto;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.custom_slider_layout, container, false);
        ImageView mImgView = view.findViewById(R.id.slide_img);

        PhotoSlider photo = mPhoto.get(position);
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
