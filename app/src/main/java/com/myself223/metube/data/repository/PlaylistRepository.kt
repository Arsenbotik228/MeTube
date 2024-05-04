package com.myself223.metube.data.repository

import androidx.lifecycle.MutableLiveData
import com.myself223.metube.base.core.Resourse
import com.myself223.metube.base.core.Resourse.*
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.data.network.Remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PlaylistRepository @Inject constructor(private val apiService: ApiService) {
    fun getPlaylist(part: String, channelsId: String): MutableLiveData<Resourse<BaseMainResponse<ItemPlaylistDto>>> {
        val liveData = MutableLiveData<Resourse<BaseMainResponse<ItemPlaylistDto>>>()
        liveData.value = Loading()
        apiService.getPlaylist(part = part, channelId = channelsId).enqueue(object :
            Callback<BaseMainResponse<ItemPlaylistDto>> {
            override fun onResponse(
                call: Call<BaseMainResponse<ItemPlaylistDto>?>,
                response: Response<BaseMainResponse<ItemPlaylistDto>?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    liveData.value = Success(data = response.body()!!)
                } else {
                    liveData.value = Error(message = response.message())
                }
            }

            override fun onFailure(call: Call<BaseMainResponse<ItemPlaylistDto>>, t: Throwable) {
                liveData.value = t.localizedMessage?.let { Error(message = it) }
            }
        })
        return liveData
    }
}
