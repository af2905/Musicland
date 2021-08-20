package com.github.af2905.musicland.data.network.api

import com.github.af2905.musicland.data.CategoriesResponseDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface BrowseApi {

    @Headers(ACCEPT_HEADER, CONTENT_TYPE_HEADER, AUTHORIZATION_BEARER_HEADER)
    @GET("browse/categories")
    suspend fun getBrowseCategories(
        @Query(ApiParams.COUNTRY) country: String? = null,
        @Query(ApiParams.LOCALE) locale: String? = null,
        @Query(ApiParams.LIMIT) limit: Int? = null,
        @Query(ApiParams.OFFSET) offset: Int? = null
    ): CategoriesResponseDto

    companion object {
        const val ACCEPT_HEADER = "Accept: application/json"
        const val CONTENT_TYPE_HEADER = "Content-Type: application/json"
        const val AUTHORIZATION_BEARER_HEADER =
            "Authorization: Bearer BQDsAcMw3Y8DnvLSr3_C90bFXKunNQeO7sxq4QwORx5qBoHmn-oJxqZmXTG9Gutg22n_8hRiogY9NkYjPmWeToXiCqfD1KeBOIDZGJ4KiPQwJNZAODl5rCxiEh3xodr_AaUCzBQdoi6nzZ7PIQSJEBWU6StCIudWrGiEdmTX0QtDfKOK"
    }
}
