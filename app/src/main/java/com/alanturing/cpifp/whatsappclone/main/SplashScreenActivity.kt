package com.alanturing.cpifp.whatsappclone.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alanturing.cpifp.whatsappclone.R
import com.alanturing.cpifp.whatsappclone.register.ui.RegisterActivity
import com.alanturing.cpifp.whatsappclone.register.ui.RegisterViewModel
import com.alanturing.cpifp.whatsappclone.register.ui.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

    private val vm:RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        lifecycleScope.launch {
            vm.isRegister()
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.user.collect {
                    when(it) {
                        is UiState.Loading-> {}
                        is UiState.Success-> {
                            val intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
                            startActivity(intent)
                        }
                        is UiState.Error ->{
                            val intent:Intent = Intent(this@SplashScreenActivity,RegisterActivity::class.java)
                            startActivity(intent)
                        }

                        else -> {}
                    }

                }

            }

        }
    }
}