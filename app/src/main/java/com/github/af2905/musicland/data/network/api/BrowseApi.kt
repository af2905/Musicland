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
            "Authorization: Bearer BQD5AXlpagJfiLvYbJgqqIStN9on1HNDGeqpiP2r3XYCTBkNbUt1Wra27kKUPk3u524vGTtSOGlzLkMf09WSSeTIy-hUOaL1cBKoPz199MjnE3r0wqEv7nO5WAnyCnrGMx0ur_Ggeg9NSN-4Uc2AXd5YtWocK276wslfFtKQZscojmmUUz5cb6DlLPzpAqWJCLhDPeqoDrs"
    }
}
