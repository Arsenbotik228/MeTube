package com.myself223.metube.ui.fragments.playlist_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.myself223.metube.R
import com.myself223.metube.base.BaseFragment
import com.myself223.metube.base.core.Resourse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.databinding.FragmentDetailPlaylistBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailPlaylistFragment : BaseFragment<FragmentDetailPlaylistBinding>(){
    private val viewModel :DetailPlaylistViewModel by viewModel()
    private lateinit var adapter :DetailPlaylistAdapter
    override fun getViewBinding(): FragmentDetailPlaylistBinding {
        return FragmentDetailPlaylistBinding.inflate(layoutInflater)
    }
   /* override fun initialize() {
        val args = DetailPlaylistFragmentArgs.fromBundle(arguments)
        args.playlistId?.let { viewModel.getPlaylistItem(id = it) }

    }*/

   /* override fun initialize() {
        val args = DetailPlaylistFragmentArgs.fromSavedStateHandle(requireView().findNavController().currentBackStackEntry?.savedStateHandle)
        if (args != null) {
            args.playlistId?.let { viewModel.getPlaylistItem(id = it) }
        }
    }*/
   override fun initialize() {
       val savedStateHandle = requireView().findNavController().currentBackStackEntry?.savedStateHandle
       if (savedStateHandle != null) {
           val args = DetailPlaylistFragmentArgs.fromSavedStateHandle(savedStateHandle)
           args.playlistId?.let { viewModel.getPlaylistItem(id = it) }
       }
   }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = DetailPlaylistAdapter()
        binding?.rvPlaylistVideo?.adapter = adapter

    }

    override fun launchObserver() {
        viewModel.playlistsDetailLiveData.observe(viewLifecycleOwner){
            when(it){
                is Resourse.Loading -> Toast.makeText(requireContext(),"LOh",Toast.LENGTH_SHORT).show()
                is Resourse.Success -> adapter.submitList(it.data?.items)
                is Resourse.Error -> Toast.makeText(requireContext(),"net ty loh",Toast.LENGTH_SHORT).show()
            }
            binding?.tvTitlePlaylist?.text = it.data?.items?.get(0)?.snippetDto?.title
            binding?.tvDescPlaylist?.text = it.data?.items?.get(0)?.snippetDto?.descriptions


        }
    }

    override fun constructorListners() {
        binding?.btnPlayVideo?.setOnClickListener{

        }
    }



}