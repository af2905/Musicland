package com.github.af2905.musicland.presentation.widget.item

import com.github.af2905.musicland.R
import com.github.af2905.musicland.data.CategoryDto
import com.github.af2905.musicland.presentation.widget.model.Model

class CategoryItem(
    val href: String,
    val icons: List<String>?,
    val id: String,
    val name: String

) : Model(VIEW_TYPE) {

    companion object {

        fun map(categoryDtoList: List<CategoryDto>?): List<CategoryItem> {
            return categoryDtoList?.map { map(it) } ?: emptyList()
        }

        private fun map(categoryDto: CategoryDto): CategoryItem {
            return CategoryItem(
                href = categoryDto.href,
                icons = categoryDto.icons?.map { it.url },
                id = categoryDto.id,
                name = categoryDto.name
            )
        }

        const val VIEW_TYPE = R.layout.list_item_category
    }

    fun interface CategoryClickListener {
        fun onClick(item: CategoryItem)
    }
}