package com.github.af2905.musicland.presentation.feature

import androidx.annotation.LayoutRes
import com.github.af2905.musicland.databinding.ListItemCategoryBinding
import com.github.af2905.musicland.presentation.widget.adapter.delegate.ViewBindingDelegateAdapter
import com.github.af2905.musicland.presentation.widget.item.CategoryItem

class CategoryAdapter(
    @LayoutRes override val viewType: Int,
    private val listener: CategoryItem.CategoryClickListener
) : ViewBindingDelegateAdapter<CategoryItem, ListItemCategoryBinding>(ListItemCategoryBinding::inflate) {

    override fun ListItemCategoryBinding.onBind(item: CategoryItem) {
        categoryTitleText.apply {
            text = item.name
            setOnClickListener { listener.onClick(item) }
        }
    }
}