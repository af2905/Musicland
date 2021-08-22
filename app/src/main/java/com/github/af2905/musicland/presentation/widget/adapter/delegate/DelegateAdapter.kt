package com.github.af2905.musicland.presentation.widget.adapter.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.github.af2905.musicland.presentation.widget.model.Model

interface DelegateAdapter {
    val viewType: Int
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder
    fun onBindViewHolder(holder: ViewHolder, items: List<Model>, position: Int)
}