package com.myself223.metube.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.myself223.metube.R
import com.myself223.metube.databinding.ActivityMainBinding
import com.myself223.metube.ui.checking_for_internet.isNetworkAvailable

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navHostFragment.navController
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (!isNetworkAvailable(this)) {
            navController.navigate(R.id.noInternetFragment)
        }
    }
}