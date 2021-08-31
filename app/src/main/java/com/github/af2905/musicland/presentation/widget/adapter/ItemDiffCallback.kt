package com.github.af2905.musicland.presentation.widget.adapter

import androidx.recyclerview.widget.DiffUtil
import com.github.af2905.musicland.presentation.widget.model.Model

class ItemDiffCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.areItemsTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}