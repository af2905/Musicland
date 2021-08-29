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
            "Authorization: Bearer BQCoLqq_aIgeiLcgJ-XIR0ooUirhrsgkVy-J1JUi15iEvZlDdPAvpFJRvLwLXncKTr6kvJP3hK_vX-Vke1OTOdFKlPB0xSZSdEJk-H_8t9ZS1uLYLTyuVVjtHm3WeQq-ZPUsJj7QBI29YqOnnLN5_4qKQL_sehC3gdTUL3E4Fo5tkpcVoQac0Xw_btOiZ3liAamvAxLOJqk"
    }
}
