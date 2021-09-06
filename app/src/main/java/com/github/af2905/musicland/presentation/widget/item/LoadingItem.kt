package com.github.af2905.musicland.presentation.widget.item

import androidx.annotation.LayoutRes
import com.github.af2905.musicland.R
import com.github.af2905.musicland.databinding.ListItemLoadingBinding
import com.github.af2905.musicland.presentation.widget.adapter.delegate.ViewBindingDelegateAdapter
import com.github.af2905.musicland.presentation.widget.model.ItemIds.LOADING_ITEM_ID
import com.github.af2905.musicland.presentation.widget.model.Model

data class LoadingItem(override val id: String = LOADING_ITEM_ID) : Model(VIEW_TYPE) {

    companion object {
        const val VIEW_TYPE = R.layout.list_item_loading
    }
}

class LoadingDelegate(
    @LayoutRes override val viewType: Int
) : ViewBindingDelegateAdapter<LoadingItem, ListItemLoadingBinding>(ListItemLoadingBinding::inflate) {
    override fun onBind(item: LoadingItem, viewBinding: ListItemLoadingBinding) {}
}