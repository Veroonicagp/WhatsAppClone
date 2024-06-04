package com.alanturing.cpifp.whatsappclone.core.network

data class MessageRequest(
    val text: String,
    val timeSent: String,
    val senderPhone: String,
    val receiverPhone: String
)
