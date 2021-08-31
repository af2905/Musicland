package com.github.af2905.musicland.presentation.widget.item

import androidx.annotation.LayoutRes
import com.github.af2905.musicland.R
import com.github.af2905.musicland.data.dto.PlaylistDto
import com.github.af2905.musicland.databinding.ListItemPlaylistBinding
import com.github.af2905.musicland.helper.loadImage
import com.github.af2905.musicland.presentation.widget.adapter.delegate.ViewBindingDelegateAdapter
import com.github.af2905.musicland.presentation.widget.model.Model

data class PlaylistItem(
    val description: String,
    val href: String,
    val id: String,
    val images: List<String>?,
    val name: String,
    val snapshotId: String,
    val tracks: Int,
    val type: String,
    val uri: String
) : Model(VIEW_TYPE) {

    override fun areItemsTheSame(item: Model): Boolean {
        return item is PlaylistItem && item.id == id
    }

    override fun areContentsTheSame(item: Model): Boolean {
        return item is PlaylistItem && item.description == description && item.images == images
                && item.name == name && item.tracks == tracks && item.type == type && item.uri == uri
    }

    companion object {
        const val VIEW_TYPE = R.layout.list_item_playlist

        fun map(playlistDtoList: List<PlaylistDto>?): List<PlaylistItem> {
            return playlistDtoList?.map { map(it) } ?: emptyList()
        }

        private fun map(playlistDto: PlaylistDto): PlaylistItem {
            return with(playlistDto) {
                PlaylistItem(
                    description = description,
                    href = href,
                    id = id,
                    images = images?.map { it.url },
                    name = name,
                    snapshotId = snapshotId,
                    tracks = tracks.total,
                    type = type,
                    uri = uri
                )
            }
        }
    }

    fun interface PlaylistClickListener {
        fun onClick(item: PlaylistItem)
    }
}

class PlaylistDelegate(
    @LayoutRes override val viewType: Int,
    private val listener: PlaylistItem.PlaylistClickListener
) : ViewBindingDelegateAdapter<PlaylistItem, ListItemPlaylistBinding>(ListItemPlaylistBinding::inflate) {
    override fun onBind(item: PlaylistItem, viewBinding: ListItemPlaylistBinding) {
        viewBinding.playlistItemLayout.setOnClickListener { listener.onClick(item) }
        viewBinding.playlistTitleText.text = item.name
        item.images?.first()?.let {
            viewBinding.playlistImage.loadImage(it)
        }
    }
}