package com.alanturing.cpifp.whatsappclone.main.chat.data

import com.alanturing.cpifp.whatsappclone.core.network.ContactResponse
import kotlinx.datetime.Instant


data class Message(
    val id: Long,
    val text: String,
    val datetime: Instant,//usar clase Instant
    val sender: Long,
    val receiver: Long
)
