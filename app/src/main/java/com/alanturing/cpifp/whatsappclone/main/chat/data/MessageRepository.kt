package com.alanturing.cpifp.whatsappclone.main.chat.data

import kotlinx.datetime.Clock
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MessageRepository @Inject constructor(private val messageNetworkRepository: MessageNetworkRepository){

    private val _message: MutableList<Message> = mutableListOf()

    val message: List<Message>
        get() = _message.toList()


    fun createMessages(messages:List<Message>){

    }
    fun addMssg(text:String,entrante:Boolean,sender:Long){
        val mssg = Message(
            sender,
            text,
            Clock.System.now(),
            entrante,
        )
        _message.add(mssg)
    }

    fun getMessage(sender: Long): List<Message>{
        val response = messageNetworkRepository.getAllMessages()
        return _message.filter { it.id ==sender }
    }
}