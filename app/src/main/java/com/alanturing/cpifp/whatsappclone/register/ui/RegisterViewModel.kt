package com.alanturing.cpifp.whatsappclone.register.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import com.alanturing.cpifp.whatsappclone.register.data.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState {

    object Started: UiState()
    object Loading: UiState()
    object Success:UiState()
    class Error(val message: String): UiState()



}

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RegisterRepository): ViewModel() {


    private val _user = MutableStateFlow<UiState>(UiState.Loading)
    val user: StateFlow<UiState>
        get() = _user.asStateFlow()

    fun register(phone: String) {

        // LLamo al metodo del repositorio para registrar un usuario
        viewModelScope.launch {
            _user.value = if (repository.register(phone)) {
                UiState.Success
            } else {
                UiState.Error("El usuario ya existe")
            }
        }

        //_user.value = User(phone)
    }


    fun isRegister() {
        viewModelScope.launch {
            _user.value = if (repository.isRegistered())
                UiState.Success
            else
                UiState.Error("no hay usuario local")
        }
    }
}