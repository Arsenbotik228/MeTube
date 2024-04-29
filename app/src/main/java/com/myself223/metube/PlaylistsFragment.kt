package com.myself223.metube

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myself223.metube.databinding.FragmentPlaylistsBinding


class PlaylistsFragment : Fragment() {
    private val binding :FragmentPlaylistsBinding by lazy {
        FragmentPlaylistsBinding.inflate(layoutInflater)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }


}