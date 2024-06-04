package com.alanturing.cpifp.whatsappclone.core.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkServiceModule {

    @Provides
    @Singleton
    fun provideNetworkService(): WhatsAppCloneApi{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://immune-spider-relative.ngrok-free.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create((WhatsAppCloneApi::class.java))

    }
}