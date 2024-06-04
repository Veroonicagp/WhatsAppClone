package com.alanturing.cpifp.whatsappclone.core

import com.alanturing.cpifp.whatsappclone.core.local.MessageLocalRepository
import com.alanturing.cpifp.whatsappclone.core.network.MessageRepositoryInterface
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import com.alanturing.cpifp.whatsappclone.main.chat.data.MessageRepository

class DefaultMessageRepository constructor(
    private val localRepository: MessageRepository,
    private val networkRepository: MessageRepository
    //??
): MessageRepositoryInterface {
    suspend fun getMessages(): List<Message> {
        val remoteMessages = networkRepository.getMessage(sender = 12)
        createMessages(remoteMessages)
        return localRepository.getMessage(sender = 2)
    }

    suspend fun createMessages(messages: List<Message>) {
        TODO("Not yet implemented")
    }
}