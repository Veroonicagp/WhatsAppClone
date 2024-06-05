package com.alanturing.cpifp.whatsappclone.main.chat.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactRepository @Inject constructor(){

    private val _contacts: MutableList<Contact> = mutableListOf()

    val contacts: List<Contact>
        get() = _contacts.toList()

    init {
        _contacts.add(Contact(102,"Joseph","San Juan", "333333333"))
        _contacts.add(Contact(103,"Verónica","González", "111111111"))
        _contacts.add(Contact(104,"Jesus","Garcia","200200200"))
    }

}