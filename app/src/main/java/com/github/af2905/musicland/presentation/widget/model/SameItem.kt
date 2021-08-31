package com.github.af2905.musicland.presentation.widget.model

interface SameItem {
    fun areItemsTheSame(item: Model): Boolean
    fun areContentsTheSame(item: Model): Boolean
}