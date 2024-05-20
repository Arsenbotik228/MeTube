package com.myself223.metube.data.models

import android.content.res.Resources
import com.google.gson.annotations.SerializedName
data class ItemPlaylistDto(
    val kind:String? = null,
    val channelTitle:String? = null,
    @SerializedName("etag")
    val tag:String? = null,
    val id: String? = null,
    val snippetDto: SnippetDto? = null,
    val contentDetails: ContentDetailsDto? = null,
    val videoOwnerChannelTitle:String? = null,
    val resourceId :Resourses ? = null
)