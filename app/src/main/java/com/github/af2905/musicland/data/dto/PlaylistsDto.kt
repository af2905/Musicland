package com.github.af2905.musicland.data.dto

import com.google.gson.annotations.SerializedName

data class PlaylistsResponseDto(
    @SerializedName("playlists") val playlistsDto: PlaylistsDto
)

data class PlaylistsDto(
    @SerializedName("href") val href: String?,
    @SerializedName("items") val items: List<PlaylistDto>,
    @SerializedName("limit") val limit: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("offset") val offset: Int,
    @SerializedName("previous") val previous: String?,
    @SerializedName("total") val total: Int
)

data class PlaylistDto(
    @SerializedName("collaborative") val collaborative: Boolean,
    @SerializedName("description") val description: String,
    @SerializedName("external_urls") val externalUrls: ExternalUrlsDto,
    @SerializedName("href") val href: String,
    @SerializedName("id") val id: String,
    @SerializedName("images") val images: List<ImageDto>?,
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: OwnerDto,
    @SerializedName("snapshot_id") val snapshotId: String,
    @SerializedName("tracks") val tracks: TracksDto,
    @SerializedName("type") val type: String,
    @SerializedName("uri") val uri: String
)

data class ExternalUrlsDto(
    @SerializedName("spotify") val spotify: String
)

data class ImageDto(
    @SerializedName("height") val height: Int?,
    @SerializedName("width") val width: Int?,
    @SerializedName("url") val url: String
)

data class OwnerDto(
    @SerializedName("display_name") val displayName: String,
    @SerializedName("external_urls") val externalUrls: ExternalUrlsDto,
    @SerializedName("href") val href: String,
    @SerializedName("id") val id: String,
    @SerializedName("type") val type: String,
    @SerializedName("uri") val uri: String
)

data class TracksDto(
    @SerializedName("href") val href: String,
    @SerializedName("total") val total: Int
)



