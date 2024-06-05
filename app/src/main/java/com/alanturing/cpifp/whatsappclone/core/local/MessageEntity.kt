package com.alanturing.cpifp.whatsappclone.core.local

// se utiliza e menssage que teniamos ya creado?
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import kotlinx.datetime.Instant


@Entity(tableName = "messages")
data class MessageEntity (
    @PrimaryKey
    val id: Long,
    val text: String,
    val dateTime: Instant,
    val sender: Long,
    val receiver: Long
)

fun List<MessageEntity>.toExternalModel(): List<Message> {
    return this.map {
        Message(
            id = it.id,
            text = it.text,
            datetime = it.dateTime,
            sender = it.sender,
            receiver = it.receiver
        )
    }
}