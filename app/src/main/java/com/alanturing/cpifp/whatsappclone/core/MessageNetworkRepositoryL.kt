package com.alanturing.cpifp.whatsappclone.core

import com.alanturing.cpifp.whatsappclone.core.network.MessageRepositoyInterface
import com.alanturing.cpifp.whatsappclone.core.network.WhatsAppCloneApi
import com.alanturing.cpifp.whatsappclone.core.network.toExternalModel
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import com.alanturing.cpifp.whatsappclone.main.chat.data.MessageRepository

class MessageNetworkRepositoryL(
    private val api: WhatsAppCloneApi
): MessageRepositoyInterface {
    override suspend fun getMessage(sender: Long): List<Message> {
        val response = api.getAllMesages()

        return if (response.isSuccessful) response.body()!!.toExternalModel()
        else emptyList()

    }

    override suspend fun createMessages(messages: List<Message>) {
        TODO("Not yet implemented")
    }


}