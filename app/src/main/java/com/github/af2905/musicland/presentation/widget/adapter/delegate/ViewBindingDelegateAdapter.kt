package com.github.af2905.musicland.presentation.widget.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.github.af2905.musicland.presentation.widget.model.Model

abstract class ViewBindingDelegateAdapter<T : Model, V : ViewBinding>(
    private val viewBindingInflater: (LayoutInflater, parent: ViewGroup, attachToParent: Boolean) -> V
) : DelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = viewBindingInflater(layoutInflater, parent, false)
        viewBinding.onCreated()
        return ViewBindingHolder(viewBinding)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder, items: List<Model>, position: Int
    ) {
        (holder as ViewBindingHolder<V>).viewBinding.onBind(items[position] as T)
    }

    open fun V.onCreated() {}

    abstract fun V.onBind(item: T)

    private class ViewBindingHolder<V : ViewBinding>(
        val viewBinding: V
    ) : BaseViewHolder(viewBinding.root)
}