package com.myself223.metube.ui.fragments.no_internet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myself223.metube.R
import com.myself223.metube.base.BaseFragment
import com.myself223.metube.databinding.FragmentNoInternetBinding

class NoInternetFragment : BaseFragment<FragmentNoInternetBinding>() {
    override fun getViewBinding(): FragmentNoInternetBinding = FragmentNoInternetBinding.inflate(layoutInflater)


}