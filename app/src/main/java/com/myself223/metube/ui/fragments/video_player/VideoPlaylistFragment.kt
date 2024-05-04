package com.myself223.metube.ui.fragments.video_player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myself223.metube.R
import com.myself223.metube.base.BaseFragment
import com.myself223.metube.databinding.FragmentVideoPlaylistBinding

class VideoPlaylistFragment : BaseFragment<FragmentVideoPlaylistBinding>() {
    override fun getViewBinding(): FragmentVideoPlaylistBinding {
        TODO("Not yet implemented")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding?.root
    }


}