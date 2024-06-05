package com.alanturing.cpifp.whatsappclone.main.chat.data

import com.alanturing.cpifp.whatsappclone.core.network.MessageRepositoyInterface
import com.alanturing.cpifp.whatsappclone.core.network.MessageResponse
import kotlinx.datetime.Instant

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
open class MessageRepository @Inject constructor(private val messageNetworkRepository: MessageNetworkRepository): MessageRepositoyInterface {

    private val _message: MutableList<Message> = mutableListOf()
    val message: List<Message>
        get() = _message.toList()

    override suspend fun createMessages(messages:List<Message>){
    }


    fun addMssg(text:String, dateTime: Instant, receiver:Long, sender:Long){
        val mssg = Message(
            sender,
            text,
            dateTime,
            receiver,
            sender

        )
        _message.add(mssg)
    }

    override suspend fun getMessage(sender: Long): List<Message>{
        val response = messageNetworkRepository.getAllMessages()
        return _message.filter { it.id ==sender }
    }

    fun getConversation(sender: Long, receiver:Long ): List<MessageResponse> {
        val response = messageNetworkRepository.getConversation(sender, receiver)
        return response
    }
}