package com.alanturing.cpifp.whatsappclone.core.local

import com.alanturing.cpifp.whatsappclone.core.network.MessageRepositoryInterface
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message

class MessageLocalRepository (
    private val messageDao: MessageDao
    // por que  es necesario los : con el interfaz de repositorio detras?
): MessageRepositoryInterface {
    suspend fun getMessages(): List<Message> {
        val messages = messageDao.getAllMessages()
        return messages.toExternalModel()
    }

    suspend fun createMessages(messages: List<Message>) {
        TODO("Not yet implemented")
    }

}