package com.myself223.metube.ui.fragments.playlist_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myself223.metube.base.core.Resourse
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.data.repository.MeTubeRepository
import kotlinx.coroutines.launch

class DetailPlaylistViewModel(private val repo:MeTubeRepository): ViewModel() {
    private val _playlistsDetailLiveData = MutableLiveData<Resourse<BaseMainResponse<ItemPlaylistDto>?>>()
    val playlistsDetailLiveData: LiveData<Resourse<BaseMainResponse<ItemPlaylistDto>?>> get() = _playlistsDetailLiveData

    fun getPlaylistItem(id:String) {
        viewModelScope.launch {
            _playlistsDetailLiveData.value = repo.getPlaylistItem(id = id).value
        }
    }


}