package com.alanturing.cpifp.whatsappclone.core.network

import com.alanturing.cpifp.whatsappclone.core.network.ContactRequest
import com.alanturing.cpifp.whatsappclone.core.network.MessageRequest
import com.alanturing.cpifp.whatsappclone.core.network.MessageResponse
import com.alanturing.cpifp.whatsappclone.register.data.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WhatsAppCloneApi {

    @GET("message")
    suspend fun getAllMessagees(@Query("user") userId:Long): List<MessageResponse>

    @POST("user")
    suspend fun registerUser(@Body user: User):Response<User>

    @POST("user")
    suspend fun register(@Body phone: ContactRequest): Response<ContactRequest>
    @GET("user")
    suspend fun readUser(@Query("phone") phone:String): Response<List<ContactRequest>>

    @GET("message")
    suspend fun getAllMesages(): Response<List<MessageResponse>>

    @POST("message")
    suspend fun createMessage(message: MessageRequest): Response<MessageResponse>

    @GET("conversation/{userId1}/{userId2}")
    suspend fun getConversation(@Path("userId1") userId1:Long ,@Path("userId2") userId2:Long): List<MessageResponse>

}