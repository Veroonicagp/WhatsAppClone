package com.alanturing.cpifp.whatsappclone.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alanturing.cpifp.whatsappclone.R
import com.alanturing.cpifp.whatsappclone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navegationBar = binding.bottomNavigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigation_container) as NavHostFragment
        val navController = navHostFragment.navController
        navegationBar.setupWithNavController(navController)
    }
}