package com.myself223.metube.ui.fragments.playlist

import androidx.fragment.app.viewModels
import com.myself223.metube.base.BaseFragment
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.databinding.FragmentPlaylistsBinding
import com.myself223.metube.ui.adapters.PlaylistFragmentAdapter.PlaylistAdapter
import com.myself223.metube.ui.view_model.playlist_view_model.PlaylistViewModel


class PlaylistsFragment : BaseFragment<FragmentPlaylistsBinding>(), PlaylistAdapter.Click {
    private lateinit var adapter: PlaylistAdapter
    override fun initialize() {
        adapter = PlaylistAdapter(this,this)
        launchObserver()
    }

    override fun getViewBinding(): FragmentPlaylistsBinding =FragmentPlaylistsBinding.inflate(layoutInflater)

    private val viewModel: PlaylistViewModel by viewModels()
    override fun constructorListners() {
        viewModel.getPlaylist("", "")

    }

    override fun launchObserver() {
        viewModel.getPlaylist( "" ,"")

    }

    override fun onClick(model: ItemPlaylistDto) {
    }


}