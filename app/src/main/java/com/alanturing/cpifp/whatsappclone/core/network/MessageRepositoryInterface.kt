package com.alanturing.cpifp.whatsappclone.core.network

import com.alanturing.cpifp.whatsappclone.main.chat.data.Message

interface MessageRepositoyInterface{

    suspend fun getMessage(sender: Long): List<Message>

    suspend fun createMessages(messages:List<Message>)

}