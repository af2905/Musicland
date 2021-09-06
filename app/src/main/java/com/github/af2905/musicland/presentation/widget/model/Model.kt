package com.github.af2905.musicland.presentation.widget.model

import androidx.annotation.LayoutRes

abstract class Model(@LayoutRes val viewType: Int) {

    abstract val id: String

    open fun areItemsTheSame(item: Model): Boolean = when {
        this::class != item::class -> false
        else -> this.id == item.id
    }

    open fun areContentsTheSame(item: Model) = this == item
}