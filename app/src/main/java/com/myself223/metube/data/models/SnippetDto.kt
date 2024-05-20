package com.myself223.metube.data.models

data class SnippetDto (
    val publishedAt:String? = null,
    val channelId:String? = null,
    val title :String? = null,
    val thumbnails:ThumbDto? = null,
    val descriptions:String? = null,
    val channelTitle:String? = null

)
