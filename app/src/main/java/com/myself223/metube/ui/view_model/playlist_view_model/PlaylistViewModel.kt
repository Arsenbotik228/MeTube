package com.myself223.metube.ui.view_model.playlist_view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myself223.metube.base.core.Resourse
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.data.repository.PlaylistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class PlaylistViewModel @Inject constructor(
    private val repo:PlaylistRepository
):ViewModel(){
        private var _livedata = MutableLiveData<Resourse<BaseMainResponse<ItemPlaylistDto>>>()
        val livedata get() = _livedata

        fun getPlaylist(part: String,channelsId :String) {
            _livedata = repo.getPlaylist(part,channelsId)
        }
}