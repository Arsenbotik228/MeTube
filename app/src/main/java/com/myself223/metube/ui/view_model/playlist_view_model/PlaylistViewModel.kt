package com.myself223.metube.ui.view_model.playlist_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myself223.metube.base.core.Resourse
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.data.repository.MeTubeRepository
import kotlinx.coroutines.launch

/*
class PlaylistViewModel (
    private val repository: MeTubeRepository
)   : ViewModel(){
    var liveData = MutableLiveData<BaseMainResponse<ItemPlaylistDto>>()
    fun getPlaylist(playlists:Int){
        liveData = repository.getPlaylist()
    }



}*/
/*class PlaylistViewModel(private val repository: MeTubeRepository) : ViewModel() {
    private val _liveData = MutableLiveData<Resourse<MutableList<BaseMainResponse<ItemPlaylistDto>?>>>()
    val liveData: MutableLiveData<Resourse<MutableList<BaseMainResponse<ItemPlaylistDto>?>>> = _liveData

    fun getPlaylist(playlists: Int) {
        viewModelScope.launch {
            _liveData.value = Resourse.Loading()
            try {
                val response = repository.getPlaylist(playlists)
                _liveData.value = Resourse.Success(response.items)
            } catch (e: Exception) {
                _liveData.value = e.message?.let { Resourse.Error(it) }
            }
        }
    }
}*/
class PlaylistViewModel(private val repository: MeTubeRepository) : ViewModel() {
    private val _liveData = MutableLiveData<Resourse<MutableList<BaseMainResponse<ItemPlaylistDto>?>>>()
    val liveData: LiveData<Resourse<MutableList<BaseMainResponse<ItemPlaylistDto>?>>> = _liveData

    fun getPlaylist() {
        viewModelScope.launch {
            _liveData.value = Resourse.Loading()
            try {
                val response = repository.getPlaylist()
                response.value?.let { baseResponse ->
                    _liveData.value = Resourse.Success(baseResponse.items as MutableList<BaseMainResponse<ItemPlaylistDto>?>)
                } ?: run {
                    _liveData.value = Resourse.Error("Error occurred while fetching playlists")
                }
            } catch (e: Exception) {
                _liveData.value = Resourse.Error(e.message.orEmpty())
            }
        }
    }

}


