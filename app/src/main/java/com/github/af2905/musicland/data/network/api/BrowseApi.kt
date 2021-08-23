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
            "Authorization: Bearer BQDu8xSsH6I0yT9EQ5eUntGVZ9HikLLZfku6Szs1w3B6X6s1_MeydUqP3nKkqaex9MVRzVWe8C_lWry6GLhML5lQVXf3dBClaRpCZfGTmIqfR15vla-DJWn39aMXxrocu3eh6tqqcZICr9sV4F3ITQE7R6IZERKz7j2OxexIF8m0w8JYoNtQ0G5JgV-55hd0jgKQUKUjpoA"
    }
}
