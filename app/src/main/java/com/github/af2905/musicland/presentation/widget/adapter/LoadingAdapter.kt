package com.github.af2905.musicland.presentation.widget.adapter

import androidx.annotation.LayoutRes
import com.github.af2905.musicland.databinding.ListItemLoadingBinding
import com.github.af2905.musicland.presentation.widget.adapter.delegate.ViewBindingDelegateAdapter
import com.github.af2905.musicland.presentation.widget.item.LoadingItem

class LoadingAdapter(
    @LayoutRes override val viewType: Int
) : ViewBindingDelegateAdapter<LoadingItem, ListItemLoadingBinding>(ListItemLoadingBinding::inflate) {
    override fun ListItemLoadingBinding.onBind(item: LoadingItem) {}
}