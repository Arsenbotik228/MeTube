package com.myself223.metube.data.models

import com.google.gson.annotations.SerializedName
data class ItemPlaylistDto(
    val kind:String? = null,
    @SerializedName("etag")
    val tag:String? = null,
    val id: String? = null,
    val snippetDto: SnippetDto? = null,
    val contentDetails: ContentDetailsDto? = null
)