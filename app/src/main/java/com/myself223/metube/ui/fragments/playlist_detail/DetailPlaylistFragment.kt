package com.myself223.metube.ui.fragments.playlist_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myself223.metube.R
import com.myself223.metube.base.BaseFragment
import com.myself223.metube.databinding.FragmentDetailPlaylistBinding

class DetailPlaylistFragment : BaseFragment<FragmentDetailPlaylistBinding>() {
    override fun getViewBinding(): FragmentDetailPlaylistBinding {
        return FragmentDetailPlaylistBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding?.root
    }


}