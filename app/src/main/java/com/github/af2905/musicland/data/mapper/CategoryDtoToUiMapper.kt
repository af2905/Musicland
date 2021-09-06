package com.github.af2905.musicland.data.mapper

import com.github.af2905.musicland.data.dto.CategoryDto
import com.github.af2905.musicland.helper.mapper.IMapper
import com.github.af2905.musicland.helper.mapper.ListMapper
import com.github.af2905.musicland.presentation.widget.item.CategoryItem

class CategoryDtoToUiMapper : IMapper<CategoryDto, CategoryItem> {
    override fun map(input: CategoryDto): CategoryItem {
        return CategoryItem(
            href = input.href,
            icons = input.icons?.map { it.url },
            id = input.id,
            name = input.name
        )
    }
}

class CategoriesDtoToUiMapper(mapper: CategoryDtoToUiMapper) :
    ListMapper<CategoryDto, CategoryItem>(mapper)