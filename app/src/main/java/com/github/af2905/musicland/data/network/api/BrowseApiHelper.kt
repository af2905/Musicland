package com.github.af2905.musicland.data.network.api

import retrofit2.Retrofit

class BrowseApiHelper(private val retrofit: Retrofit) {
    fun provideBrowseApi(): BrowseApi = retrofit.create(BrowseApi::class.java)
}
