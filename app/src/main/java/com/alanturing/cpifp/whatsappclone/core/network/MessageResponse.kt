package com.alanturing.cpifp.whatsappclone.core.network

import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import kotlinx.datetime.Instant


data class MessageResponse(
    val id: Long,
    val text: String,
    val dateTime: Instant,
    val sender: Long,
    val reciver: Long
)

fun List<MessageResponse>.toExternalModel(): List<Message> {
    return this.map {
        Message(
            id = it.id,
            text = it.text,
            datetime = it.dateTime,
            sender = it.sender,
            receiver = it.reciver
        )
    }
}


