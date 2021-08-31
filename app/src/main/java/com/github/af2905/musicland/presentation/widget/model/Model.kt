package com.github.af2905.musicland.presentation.widget.model

import androidx.annotation.LayoutRes

abstract class Model(@LayoutRes val viewType: Int) {
    abstract fun areItemsTheSame(item: Model): Boolean
    abstract fun areContentsTheSame(item: Model): Boolean
}