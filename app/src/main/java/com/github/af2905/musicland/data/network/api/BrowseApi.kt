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
            "Authorization: Bearer BQCjSVrQhMPZfex0t574MX0SaxD5_PcT_YmqK4Tg4H1nRhILkqCGPBjHwpQ9nB8RhMirFQQre9ffWXiUGeZInK2I04e0-ngIOw9FTWgXLujO8b9uKm4qaewmxLDYear81FcUbn8YvbK_O4FVPYTfCmpvN0o2YuzxbXYhFqcEagd278gkYZHCJn-lJjQjobiRlII7zxh4F1U"
    }
}
