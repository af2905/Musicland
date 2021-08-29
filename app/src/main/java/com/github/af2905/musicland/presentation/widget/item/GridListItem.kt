package com.github.af2905.musicland.presentation.widget.item

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.musicland.R
import com.github.af2905.musicland.databinding.ListItemListBinding
import com.github.af2905.musicland.presentation.widget.adapter.delegate.CompositeDelegateAdapter
import com.github.af2905.musicland.presentation.widget.adapter.delegate.ViewBindingDelegateAdapter
import com.github.af2905.musicland.presentation.widget.item.GridListItem.Companion.GRID_LIST_DEFAULT_SPAN_COUNT
import com.github.af2905.musicland.presentation.widget.model.Model

class GridListItem(val list: List<Model>) : Model(VIEW_TYPE) {

    companion object {
        const val VIEW_TYPE = R.layout.list_item_list
        const val GRID_LIST_DEFAULT_SPAN_COUNT = 2
    }
}

class GridListDelegate(
    @LayoutRes override val viewType: Int,
    val adapter: () -> CompositeDelegateAdapter,
    private val spanCount: Int = GRID_LIST_DEFAULT_SPAN_COUNT,
    private val decoration: ((Context) -> RecyclerView.ItemDecoration)? = null
) : ViewBindingDelegateAdapter<GridListItem, ListItemListBinding>(ListItemListBinding::inflate) {
    override fun onBind(item: GridListItem, viewBinding: ListItemListBinding) {
        viewBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(this.context, spanCount)
            adapter = adapter()
            (adapter as CompositeDelegateAdapter).submitList(item.list)
            decoration?.let { addItemDecoration(it.invoke(this.context)) }
        }
    }
}