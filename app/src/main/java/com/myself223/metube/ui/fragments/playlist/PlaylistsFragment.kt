package com.myself223.metube.ui.fragments.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.myself223.metube.R
import com.myself223.metube.base.BaseFragment
import com.myself223.metube.base.core.Resourse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.databinding.FragmentPlaylistsBinding
import com.myself223.metube.ui.adapters.playlist_fragment_adapter.PlaylistAdapter
import com.myself223.metube.ui.view_model.playlist_view_model.PlaylistViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlaylistsFragment : BaseFragment<FragmentPlaylistsBinding>() {
    private val adapter: PlaylistAdapter by lazy {PlaylistAdapter(requireContext(),this::click)  }
    override fun getViewBinding(): FragmentPlaylistsBinding {

        return FragmentPlaylistsBinding.inflate(layoutInflater)

    }


    private val viewModel: PlaylistViewModel by viewModel()
    override fun launchObserver() {
        binding?.rvPlaylists?.adapter = adapter
        viewModel.getPlaylist()
        viewModel.playlistsLiveData.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resourse.Loading -> {

                }
                is Resourse.Success -> {
                    adapter.submitList(resource.data?.items)
                }
                is Resourse.Error -> {
                }
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.rvPlaylists?.adapter = adapter
        viewModel.getPlaylist()
        viewModel.playlistsLiveData.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resourse.Loading -> {

                }
                is Resourse.Success -> {
                    adapter.submitList(resource.data?.items)
                }
                is Resourse.Error -> {
                }
            }
        }




    }


    private fun click(id:String?) {
        findNavController()
            .navigate(
                PlaylistsFragmentDirections.actionPlaylistFragmentToDetailPlaylistFragment()
                    .setPlaylistId(id))

    }
}
