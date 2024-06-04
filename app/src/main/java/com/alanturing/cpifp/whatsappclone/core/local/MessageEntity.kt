package com.alanturing.cpifp.whatsappclone.core.local

import androidx.room.Entity
import androidx.room.PrimaryKey
// se utiliza e menssage que teniamos ya creado?
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message

@Entity(tableName = "messages")
data class MessageEntity (
    @PrimaryKey

    val id: Long,
    val text: String,
)

fun List<MessageEntity>.toExternalModel(): List<Message> {
    return this.map {
        Message(
            id = it.id,
            text = it.text,
            datetime = null,
            entrante = false
        )
    }
}