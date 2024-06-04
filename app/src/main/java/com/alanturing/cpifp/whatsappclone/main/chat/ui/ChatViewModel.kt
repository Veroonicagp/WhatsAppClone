package com.alanturing.cpifp.whatsappclone.main.chat.ui

import androidx.lifecycle.ViewModel
import com.alanturing.cpifp.whatsappclone.main.chat.data.MessageRepository
import com.alanturing.cpifp.whatsappclone.register.data.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


sealed class UiState {

    object Started: UiState()
    object Loading: UiState()
    object Success:UiState()
    class Error(val message: String): UiState()



}
@HiltViewModel
class ChatViewModel @Inject constructor(private val repository: MessageRepository): ViewModel() {
}