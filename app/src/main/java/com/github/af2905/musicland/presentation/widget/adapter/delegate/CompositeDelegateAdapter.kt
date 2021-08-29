package com.github.af2905.musicland.presentation.widget.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.ListAdapter
import com.github.af2905.musicland.presentation.widget.adapter.ItemDiffCallback
import com.github.af2905.musicland.presentation.widget.model.Model
import java.lang.IllegalStateException

class CompositeDelegateAdapter(vararg adapters: DelegateAdapter) :
    ListAdapter<Model, BaseViewHolder>(ItemDiffCallback()) {

    private val delegateAdapters = adapters.associateBy { it.viewType }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return delegateAdapters[viewType]?.onCreateViewHolder(parent, viewType)
            ?: throw IllegalStateException("Unexpected viewType: $viewType")
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        delegateAdapters[getItemViewType(position)]?.onBindViewHolder(holder, currentList, position)
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].viewType
    }
}