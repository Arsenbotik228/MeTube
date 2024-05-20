package com.myself223.metube.data.models

import com.google.gson.annotations.SerializedName

data class BaseMainResponse<T>(
    val kind:String? = null,
    @SerializedName("etag")
    val tag:String? = null,
    val nextPageToken: String? = null,
    val prevPageToken: String? = null,
    val items:List<T>,
    val pageInfo: PageInfoDto? = null,
)
