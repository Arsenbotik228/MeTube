package com.myself223.metube.data.network.Remote

import com.myself223.metube.BuildConfig.API_KEY
import com.myself223.metube.BuildConfig.CHANEL_ID
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylist(
        @Query("part") part : String? = PART ,
        @Query("channelId") channelId : String? = CHANEL_ID ,
        @Query("ApiKey") key : String = API_KEY,
        @Query("maxResults") max : Int = MAX_RESULT,
        ): Call<BaseMainResponse<ItemPlaylistDto>>
    companion object{
        const val PART = "snippet,contentDetails"
        const val MAX_RESULT = 50
    }
}