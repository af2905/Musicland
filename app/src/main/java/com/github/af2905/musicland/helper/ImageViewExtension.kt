package com.github.af2905.musicland.helper

import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.github.af2905.musicland.R
import com.google.android.material.imageview.ShapeableImageView

fun ShapeableImageView.loadImage(src: String?) {
    val options: RequestOptions = RequestOptions()
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
    Glide.with(this)
        .load(src)
        .apply(options)
        .into(this)
}

