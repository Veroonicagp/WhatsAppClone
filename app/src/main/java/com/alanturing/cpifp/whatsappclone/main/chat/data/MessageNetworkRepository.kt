package com.alanturing.cpifp.whatsappclone.main.chat.data

import com.alanturing.cpifp.whatsappclone.core.network.MessageResponse
import com.alanturing.cpifp.whatsappclone.core.network.WhatsAppCloneApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

//se pude mezclar con el creado para local
@Singleton
class MessageNetworkRepository @Inject constructor(
    private val networkService: WhatsAppCloneApi){

    fun getAllMessages(): List<MessageResponse> {
        return runBlocking {
            return@runBlocking withContext(Dispatchers.IO) {
                return@withContext networkService.getAllMessagees(1002)
            }
        }
    }

    fun getConversation(sender: Long, receiver:Long): List<MessageResponse> {
        return runBlocking {
            return@runBlocking withContext(Dispatchers.IO) {
                return@withContext networkService.getConversation(1,2)
            }
        }
    }

}