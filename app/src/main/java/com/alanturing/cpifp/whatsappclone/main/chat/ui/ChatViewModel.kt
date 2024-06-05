package com.alanturing.cpifp.whatsappclone.main.chat.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.cpifp.whatsappclone.main.chat.data.MessageRepository
import com.alanturing.cpifp.whatsappclone.register.data.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant

import javax.inject.Inject


sealed class UiState {

    object Started: UiState()
    object Loading: UiState()
    object Success:UiState()
    class Error(val message: String): UiState()



}
@HiltViewModel
class ChatViewModel @Inject constructor(private val repository: MessageRepository): ViewModel() {
    private val _message: MutableStateFlow<UiState> = MutableStateFlow(UiState.Started)
    val message: StateFlow<UiState>
        get() = _message.asStateFlow()
    fun newMessage(text:String, dateTime: Instant, userId1:Long, userId2:Long){
        viewModelScope.launch{
            _message.value = UiState.Loading
            val newMessage = repository.addMssg(text, dateTime,userId1,userId2)


        }
    }
}