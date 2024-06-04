package com.alanturing.cpifp.whatsappclone.core

import com.alanturing.cpifp.whatsappclone.core.network.MessageRepositoryInterface
import com.alanturing.cpifp.whatsappclone.core.network.WhatsAppCloneApi
import com.alanturing.cpifp.whatsappclone.core.network.toExternalModel
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message

class MessageNetworkRepositoryL (
private val api:WhatsAppCloneApi
): MessageRepositoryInterface {
    suspend fun getMessages(): List<Message> {
        val response = api.getAllMesages()

        return if (response.isSuccessful) response.body()!!.toExternalModel()
        else emptyList()

    }

    suspend fun createMessages(messages: List<Message>) {
        TODO("Not yet implemented")
    }


}