package com.alanturing.cpifp.whatsappclone.main.chat.data

import kotlinx.datetime.Instant


data class Message(
    val id: Long,
    val text: String,
    val datetime: Instant?,//usar clase Instant
    val entrante: Boolean
)
