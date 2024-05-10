package com.myself223.metube.ui.view_model.playlist_view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.data.repository.MeTubeRepository

class PlaylistViewModel (
    private val repository: MeTubeRepository
)   : ViewModel(){
    var liveData = MutableLiveData<BaseMainResponse<ItemPlaylistDto>>()
    fun getPlaylist(playlists:Int){
        liveData = repository.getPlaylist()
    }



}