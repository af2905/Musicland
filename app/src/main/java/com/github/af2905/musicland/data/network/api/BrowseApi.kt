package com.github.af2905.musicland.data.network.api

import com.github.af2905.musicland.data.dto.CategoriesResponseDto
import com.github.af2905.musicland.data.dto.PlaylistsResponseDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
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

    @Headers(ACCEPT_HEADER, CONTENT_TYPE_HEADER, AUTHORIZATION_BEARER_HEADER)
    @GET("browse/categories/{category_id}/playlists")
    suspend fun getBrowseCategoriesPlaylists(
        @Path(ApiParams.CATEGORY_ID) categoryId: String,
        @Query(ApiParams.COUNTRY) country: String? = null,
        @Query(ApiParams.LIMIT) limit: Int? = null,
        @Query(ApiParams.OFFSET) offset: Int? = null
    ): PlaylistsResponseDto

    companion object {
        const val ACCEPT_HEADER = "Accept: application/json"
        const val CONTENT_TYPE_HEADER = "Content-Type: application/json"
        const val AUTHORIZATION_BEARER_HEADER =
            "Authorization: Bearer BQBuwgRqGfGYhTbzKeYowxc-JmJQQMQnuXlc-LgIuMni7cdXZHrd4CAlP55dBXviDcPFMp-Iwtw9CJkkooWpT__kTG0YocvoJWBMkJkrCe_h6WULA9Sv0pQAMJKyx2-0-W0HCPveVmNg2S-8oSCHCTVEPg4lmL0vI1Z495t4wQ05mNh8sKcTnaKEdielmk9hiwRgDnWzTPw"
    }
}
