package com.alanturing.cpifp.whatsappclone.core.network

import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import kotlinx.datetime.Instant


data class MessageResponse(
    val id: Long,
    val text: String,
    val dateTime: Instant,
    val sender: ContactResponse,
    val receiver: ContactResponse
)

fun List<MessageResponse>.toExternalModel(): List<Message> {
    return this.map {
        Message(
            id = it.id,
            text = it.text,
            datetime = null,
            entrante = false


        )
    }
}


