package com.github.af2905.musicland.data.mapper

import com.github.af2905.musicland.data.dto.PlaylistDto
import com.github.af2905.musicland.helper.mapper.IMapper
import com.github.af2905.musicland.helper.mapper.ListMapper
import com.github.af2905.musicland.presentation.widget.item.PlaylistItem

class PlaylistDtoToUiMapper : IMapper<PlaylistDto, PlaylistItem> {
    override fun map(input: PlaylistDto): PlaylistItem {
        return with(input) {
            PlaylistItem(
                id = id,
                description = description,
                href = href,
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

class PlaylistsDtoToUiMapper(mapper: PlaylistDtoToUiMapper) :
    ListMapper<PlaylistDto, PlaylistItem>(mapper)