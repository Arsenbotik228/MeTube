package com.myself223.metube.ui.fragments.no_internet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.myself223.metube.base.BaseFragment
import com.myself223.metube.databinding.FragmentNoInternetBinding
import com.myself223.metube.ui.checking_for_internet.isNetworkAvailable

class NoInternetFragment : BaseFragment<FragmentNoInternetBinding>() {
    override fun getViewBinding(): FragmentNoInternetBinding = FragmentNoInternetBinding.inflate(layoutInflater)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnCheck?.setOnClickListener{
            if (!isNetworkAvailable(requireContext())) {
                Toast.makeText(requireContext(),"Все еще нет интеренета", Toast.LENGTH_SHORT).show()


            }else{
                findNavController().navigateUp()

            }


        }
    }


}