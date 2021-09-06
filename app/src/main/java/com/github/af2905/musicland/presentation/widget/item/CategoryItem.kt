package com.github.af2905.musicland.presentation.widget.item

import androidx.annotation.LayoutRes
import com.github.af2905.musicland.R
import com.github.af2905.musicland.databinding.ListItemCategoryBinding
import com.github.af2905.musicland.helper.loadImage
import com.github.af2905.musicland.presentation.widget.adapter.delegate.ViewBindingDelegateAdapter
import com.github.af2905.musicland.presentation.widget.model.Model

data class CategoryItem(
    override val id: String,
    val href: String,
    val icons: List<String>?,
    val name: String
) : Model(VIEW_TYPE) {

    override fun areContentsTheSame(item: Model): Boolean {
        return item is CategoryItem && item.name == name && item.icons == icons
    }

    companion object {
        const val VIEW_TYPE = R.layout.list_item_category
    }

    fun interface CategoryClickListener {
        fun onClick(item: CategoryItem)
    }
}

class CategoryDelegate(
    @LayoutRes override val viewType: Int,
    private val listener: CategoryItem.CategoryClickListener
) : ViewBindingDelegateAdapter<CategoryItem, ListItemCategoryBinding>(ListItemCategoryBinding::inflate) {

    /*    lateinit var categoryItem : CategoryItem
    private val clickListener = View.OnClickListener{ listener.onClick(categoryItem)  }*/

    override fun onBind(item: CategoryItem, viewBinding: ListItemCategoryBinding) {
        viewBinding.categoryItemLayout.setOnClickListener { listener.onClick(item) }
        viewBinding.categoryTitleText.text = item.name
        item.icons?.first().let {
            viewBinding.categoryImage.loadImage(it)
        }
    }
}

/*    override fun onBind(item: CategoryItem, viewBinding: ListItemCategoryBinding) {
        categoryItem = item
        viewBinding.categoryTitleText.apply {
            text = categoryItem.name
            setOnClickListener(clickListener)
        }
    }*/