package com.alanturing.cpifp.whatsappclone.register.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.alanturing.cpifp.whatsappclone.core.network.ContactRequest
import com.alanturing.cpifp.whatsappclone.core.network.WhatsAppCloneApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


private val PHONE_KEY  = stringPreferencesKey("phone")
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

///
@Singleton
class RegisterRepository @Inject constructor(@ApplicationContext val context:Context,
                                             private val api:WhatsAppCloneApi){

    suspend fun register(phone:String):Boolean {
        val response = api.register(ContactRequest(phone=phone))

        return if (response.isSuccessful) {
            context.dataStore.edit { settings ->
                settings[PHONE_KEY] = phone
            }
            true
        } else {
            false
        }

    }

    @SuppressLint("SuspiciousIndentation")
    suspend fun isRegistered(): Boolean {
        val localPhone = context.dataStore.data.map {
            it[PHONE_KEY] ?: ""
        }.first()

        // Si el telefono local es vacio, no estoy registrado
        return if (localPhone.isBlank()) {
            false
        }
        else {
            val response = api.readUser(localPhone)
            response.isSuccessful
        }

    }
}