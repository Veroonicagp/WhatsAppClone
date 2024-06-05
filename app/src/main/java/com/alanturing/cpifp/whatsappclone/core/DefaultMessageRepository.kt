package com.alanturing.cpifp.whatsappclone.core

import com.alanturing.cpifp.whatsappclone.core.network.MessageRepositoyInterface
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import com.alanturing.cpifp.whatsappclone.main.chat.data.MessageRepository

class DefaultMessageRepository(
    private val localRepository: MessageRepositoyInterface,
    private val networkRepository: MessageRepositoyInterface,
): MessageRepositoyInterface {
    override suspend fun getMessage(sender: Long): List<Message> {
        val remoteMessages = networkRepository.getMessage(sender = 12)
        createMessages(remoteMessages)
        return localRepository.getMessage(sender = 2)
    }

    override suspend fun createMessages(messages: List<Message>) {
        TODO("Not yet implemented")
    }
}