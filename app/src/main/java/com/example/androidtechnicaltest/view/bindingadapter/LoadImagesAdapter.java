package com.example.androidtechnicaltest.view.bindingadapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.androidtechnicaltest.util.Constants;

public class LoadImagesAdapter {
    @BindingAdapter({"loadImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(Constants.BASE_IMAGE_URL + imageUrl).into(view);
    }
}
