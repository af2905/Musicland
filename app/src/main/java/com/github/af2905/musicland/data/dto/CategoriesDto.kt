package com.github.af2905.musicland.data.dto

import com.google.gson.annotations.SerializedName

data class CategoriesResponseDto(
    @SerializedName("categories") val categoriesDto: CategoriesDto
)

data class CategoriesDto(
    @SerializedName("href") val href: String,
    @SerializedName("items") val items: List<CategoryDto>?,
    @SerializedName("limit") val limit: Int,
    @SerializedName("next") val next: String,
    @SerializedName("offset") val offset: Int,
    @SerializedName("previous") val previous: String?,
    @SerializedName("total") val total: Int
)

data class CategoryDto(
    @SerializedName("href") val href: String,
    @SerializedName("icons") val icons: List<CategoryIconDto>?,
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)

data class CategoryIconDto(
    @SerializedName("height") val height: Int?,
    @SerializedName("width") val width: Int?,
    @SerializedName("url") val url: String
)
