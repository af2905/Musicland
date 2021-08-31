package com.github.af2905.musicland.presentation.widget.model

import androidx.annotation.LayoutRes

abstract class Model(@LayoutRes val viewType: Int) : SameItem {
    override fun areItemsTheSame(item: Model): Boolean {
        return item === this
    }

    override fun areContentsTheSame(item: Model): Boolean {
        return item == this
    }
}