package com.alanturing.cpifp.whatsappclone.main.di

import android.content.Context
import androidx.room.Room
import com.alanturing.cpifp.whatsappclone.core.DefaultMessageRepository
import com.alanturing.cpifp.whatsappclone.core.MessageNetworkRepositoryL
import com.alanturing.cpifp.whatsappclone.core.local.AppDatabase
import com.alanturing.cpifp.whatsappclone.core.local.MessageDao
import com.alanturing.cpifp.whatsappclone.core.local.MessageLocalRepository
import com.alanturing.cpifp.whatsappclone.core.network.MessageRepositoryInterface
import com.alanturing.cpifp.whatsappclone.core.network.WhatsAppCloneApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WhatsAppCloneModule {

    // LOCAL
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            name="app_db"
        ).build()

    }

    @Provides
    @Singleton
    fun provideMessageDao(database: AppDatabase): MessageDao {
        return database.messageDao()
    }


    // REPOSITORIES
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class NetworkRepository
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalRepository

    @Provides
    @Singleton
    @LocalRepository
    fun provideLocalRepository(dao:MessageDao): MessageRepositoryInterface {
        return MessageLocalRepository(dao)
    }

    @Provides
    @Singleton
    @NetworkRepository
    fun provideNetworkRepository(api:WhatsAppCloneApi): MessageRepositoryInterface
    {
        return MessageNetworkRepositoryL(api)
    }


}