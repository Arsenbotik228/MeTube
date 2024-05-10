package com.myself223.metube.ui.fragments.playlist

import android.util.Log
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.myself223.metube.R
import com.myself223.metube.base.BaseFragment
import com.myself223.metube.base.core.Resourse
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.databinding.FragmentPlaylistsBinding
import com.myself223.metube.ui.adapters.playlist_fragment_adapter.PlaylistAdapter
import com.myself223.metube.ui.view_model.playlist_view_model.PlaylistViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlaylistsFragment : BaseFragment<FragmentPlaylistsBinding>(), PlaylistAdapter.Click {
    private lateinit var adapter: PlaylistAdapter
    private val viewModel: PlaylistViewModel by viewModel()
    private var playlists = 10

    override fun initialize() {
        adapter = PlaylistAdapter(this, this)
        binding?.rvPlaylists?.adapter = adapter

    }

    override fun launchObserver() {
        viewModel.getPlaylist(page = playlists)
        viewModel.liveData.observe(viewLifecycleOwner) { resourse ->
            when (resourse) {
                is Resourse.Loading<*> -> {
                    binding?.progress?.isVisible = true
                }
                is Resourse.Success<*> -> {
                    binding?.progress?.isGone = true
                    binding?.rvPlaylists?.isVisible = true
                    adapter.submitList(resourse.data)
                }
                is Resourse.Error<*> -> {
                    binding?.progress?.isGone = true
                    Toast.makeText(
                        requireContext(),
                        "Упс! Произошла какая-то ошибка",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("ololo", resourse.message.orEmpty())
                }
            }
        }
    }

    override fun getViewBinding(): FragmentPlaylistsBinding {
        return FragmentPlaylistsBinding.inflate(layoutInflater)
    }

    override fun constructorListners() {
        binding?.btnLoadMore?.setOnClickListener {
            playlists+10
            launchObserver()
        }

    }



    override fun onClick(model: BaseMainResponse<ItemPlaylistDto>) {
        findNavController().navigate(R.id.videoPlaylistFragment)
    }
}
