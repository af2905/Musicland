package com.github.af2905.musicland.presentation.widget.decorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.musicland.presentation.widget.item.GridListItem.Companion.GRID_LIST_DEFAULT_SPAN_COUNT

class GridListItemDecorator(
    private val spanCount: Int = GRID_LIST_DEFAULT_SPAN_COUNT,
    private val marginTop: Int = 0,
    private val marginBottom: Int = 0,
    val marginStart: Int = 0,
    val marginEnd: Int = 0,
    val spacing: Int = 0
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            val pos = parent.getChildAdapterPosition(view)
            val even = pos % spanCount == 0
            if (even) {
                right = spacing
                left = marginEnd
            } else {
                left = spacing
                right = marginStart
            }
            top = marginTop
            bottom = marginBottom

        }
    }
}