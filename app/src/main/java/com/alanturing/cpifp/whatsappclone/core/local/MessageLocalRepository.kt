package com.alanturing.cpifp.whatsappclone.core.local

import com.alanturing.cpifp.whatsappclone.core.network.MessageRepositoyInterface
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import com.alanturing.cpifp.whatsappclone.main.chat.data.MessageRepository

class MessageLocalRepository(
    private val messageDao: MessageDao
): MessageRepositoyInterface {
    override suspend fun getMessage(sender: Long): List<Message> {
        val messages = messageDao.getAllMessages()
        return messages.toExternalModel()
    }

    override suspend fun createMessages(messages: List<Message>) {
        TODO("Not yet implemented")
    }

}