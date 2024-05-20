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

/*class PlaylistViewModel (
    private val repository: MeTubeRepository
)   : ViewModel(){
    var liveData = MutableLiveData<BaseMainResponse<ItemPlaylistDto>?>()
    fun getPlaylist(){
        liveData = repository.getPlaylist()
    }



}*/
class PlaylistViewModel(
    private val repository: MeTubeRepository
) : ViewModel() {
    private val _playlistsLiveData = MutableLiveData<Resourse<BaseMainResponse<ItemPlaylistDto>?>>()
    val playlistsLiveData: LiveData<Resourse<BaseMainResponse<ItemPlaylistDto>?>> get() = _playlistsLiveData

    fun getPlaylist() {
        viewModelScope.launch {
            _playlistsLiveData.value = repository.getPlaylist().value
        }
    }
}
/*class PlaylistViewModel(
    private val repository: MeTubeRepository
) : ViewModel() {
    private val _playlistsLiveData =
        LiveData<Resourse<BaseMainResponse<ItemPlaylistDto>?>> = MutableLiveData()
    var liveData get() = _playlistsLiveData

    fun getPlaylist() =
        _playlistsLiveData = repository.getPlaylist()
}*/

    /*fun getPlaylist() {
        _playlistsLiveData.value = Resourse.Loading()
        viewModelScope.launch {
            try {
                val response = repository.getPlaylist()
                _playlistsLiveData.value = Resourse.Success(response.value)
            } catch (e: Exception) {
                _playlistsLiveData.value = Resourse.Error(e.message ?: "Unknown error")
            }
        }
    }*/





