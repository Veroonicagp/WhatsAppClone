package com.alanturing.cpifp.whatsappclone.main.chat.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactRepository @Inject constructor(){

    private val _contacts: MutableList<Contact> = mutableListOf()

    val contacts: List<Contact>
        get() = _contacts.toList()

    init {
        _contacts.add(Contact(1,"Joseph","San Juan"))
        _contacts.add(Contact(2,"Verónica","González"))
        _contacts.add(Contact(3,"Jesus","Garcia"))
    }

}