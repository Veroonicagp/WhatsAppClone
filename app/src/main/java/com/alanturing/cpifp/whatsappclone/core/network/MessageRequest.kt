package com.alanturing.cpifp.whatsappclone.core.network

import kotlinx.datetime.Instant


data class MessageRequest(
    val text: String,
    val timeSent: Instant,
    val senderPhone: String,
    val receiverPhone: String
)
