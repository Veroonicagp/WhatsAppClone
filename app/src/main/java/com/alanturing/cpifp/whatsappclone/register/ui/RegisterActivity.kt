package com.alanturing.cpifp.whatsappclone.register.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alanturing.cpifp.whatsappclone.databinding.ActivityRegisterBinding
import com.alanturing.cpifp.whatsappclone.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    //asocio VM a la Act(ViewModels)
    private val viewModel: RegisterViewModel by viewModels()

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //adopta las corrutinas
        lifecycleScope.launch {
            //cada vez que se inicie la act haz..
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.user.collect{uiState ->
                    binding.carga.visibility = View.GONE
                    binding.intriTelefono.error = null

                    when(uiState){
                        is UiState.Started -> {}
                        is UiState.Error ->{
                            binding.intriTelefono.error
                        }
                        is UiState.Loading ->{
                            binding.carga.visibility = View.VISIBLE
                        }

                        is UiState.Success->{
                            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }


                }
            }
        }

        val bttn = binding.RegisterBttn

        bttn.setOnClickListener(){
            binding.intriTelefono.error = null
            if(binding.numTelef.text.isNullOrBlank()){
                binding.intriTelefono.error = "Introduzca Numero de telefono"
            }
            else{
                viewModel.register(binding.numTelef.text.toString())
            }


        }




    }
}