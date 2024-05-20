package com.myself223.metube.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.bumptech.glide.load.engine.Resource
import com.myself223.metube.base.core.Resourse
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.data.network.Remote.ApiService
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

/*
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
*//*class MeTubeRepository  (private val apiService: ApiService){
    fun getPlaylist():MutableLiveData<BaseMainResponse<ItemPlaylistDto>>{
        val liveData = MutableLiveData<BaseMainResponse<ItemPlaylistDto>>()
        apiService.getPlaylist().enqueue(object  : Callback<BaseMainResponse<ItemPlaylistDto>>{
            override fun onResponse(
                call: Call<BaseMainResponse<ItemPlaylistDto>>,
                response: Response<BaseMainResponse<ItemPlaylistDto>>
            ) {
                if (response.isSuccessful){
                    liveData.value = response.body()
                }

            }

            override fun onFailure(call: Call<BaseMainResponse<ItemPlaylistDto>>, t: Throwable) {
                t.message?.let { Log.e("ololo", it) }
            }

        })

        return liveData
    }
}*/
class MeTubeRepository(private val apiService: ApiService) {
    fun getPlaylist(): LiveData<Resourse<BaseMainResponse<ItemPlaylistDto>?>> = liveData(Dispatchers.IO) {
        val result = apiService.getPlaylist()
        emit(Resourse.Loading())
        if (result.isSuccessful) {
            emit(Resourse.Success(data = result.body()))
        } else {
            emit(Resourse.Error(message = result.message()))
        }
    } fun getPlaylistItem(id :String): LiveData<Resourse<BaseMainResponse<ItemPlaylistDto>?>> = liveData(Dispatchers.IO) {
        val result = apiService.getDetailPlaylist(playlistId = id)
        emit(Resourse.Loading())
        if (result.isSuccessful) {
            emit(Resourse.Success(data = result.body()))
        } else {
            emit(Resourse.Error(message = result.message()))
        }
    }
}



    /*  val liveData = MutableLiveData<BaseMainResponse<ItemPlaylistDto>?>()
        apiService.getPlaylist().enqueue(object : Callback<BaseMainResponse<ItemPlaylistDto>> {
            override fun onResponse(
                call: Call<BaseMainResponse<ItemPlaylistDto>>,
                response: Response<BaseMainResponse<ItemPlaylistDto>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    liveData.value = response.body()
                } else {
                    liveData.value = null
                }
            }

            override fun onFailure(call: Call<BaseMainResponse<ItemPlaylistDto>>, t: Throwable) {
                t.message?.let { Log.e("ololo", it) }
                liveData.value = null*/





