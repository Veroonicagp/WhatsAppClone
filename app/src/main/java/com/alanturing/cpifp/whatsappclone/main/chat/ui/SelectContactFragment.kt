package com.alanturing.cpifp.whatsappclone.main.chat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alanturing.cpifp.whatsappclone.main.chat.data.Chat
import com.alanturing.cpifp.whatsappclone.main.chat.data.ChatRepository
import com.alanturing.cpifp.whatsappclone.main.chat.data.Contact
import com.alanturing.cpifp.whatsappclone.main.chat.data.ContactRepository
import com.alanturing.cpifp.whatsappclone.databinding.FragmentSelectContactBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SelectContactFragment : Fragment() {
    private lateinit var binding: FragmentSelectContactBinding
    @Inject
    lateinit var chatRepository: ChatRepository
    @Inject
    lateinit var contactRepository: ContactRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectContactBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Recupero el RV de pantalla
        val recyclerView = binding.contactList
        // Lo configurp par scroll vertical
        recyclerView.layoutManager = LinearLayoutManager(context)
        //Creo el adaptador y le pso la lista de contactos
        val adapter =  ContactListAdapter(::toChat)
        adapter.submitList(contactRepository.contacts)
        recyclerView.adapter = adapter
    }

    fun toChat(view:View,contact: Contact){

        val chat:  Chat? = chatRepository.chats.find {
            it.to == contact.id
        }

        if (chat == null){
            chatRepository.createChat(contact)
        }

        val action = SelectContactFragmentDirections.actionSelectContactFragmentToChatFragment(contact.id)
        findNavController().navigate(action)
    }

}