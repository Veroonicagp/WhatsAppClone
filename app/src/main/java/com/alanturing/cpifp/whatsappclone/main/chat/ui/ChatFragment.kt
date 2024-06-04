package com.alanturing.cpifp.whatsappclone.main.chat.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alanturing.cpifp.whatsappclone.main.chat.data.Contact
import com.alanturing.cpifp.whatsappclone.main.chat.data.ContactRepository
import com.alanturing.cpifp.whatsappclone.main.chat.data.MessageRepository
import com.alanturing.cpifp.whatsappclone.databinding.FragmentChatBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding
    private val args: ChatFragmentArgs by navArgs()
    @Inject
    lateinit var contactRepository: ContactRepository

    @Inject
    lateinit var messageRepository: MessageRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }


    private fun sendMessage(view:View) {
        val rv = binding.messageList
        val text = binding.editMssg.text.toString()

        if (text.isNotBlank()) {
            messageRepository.addMssg(text,false,args.id)
            val adapter: MessageListAdapter = rv.adapter as MessageListAdapter
            adapter.submitList(messageRepository.getMessage((args.id)))
            binding.editMssg.text?.clear()

            // Cerramos el teclado PROFEE!!(Detalles Visuales)
            //val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            //inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id


        val contact: Contact? = contactRepository.contacts.find {
            it.id == id
        }

        contact?.let{
            binding.contactName.text = "${it.name} ${it.surname}"
        }

        //// Creo el adaptador y le paso la lista de contactos del repo
        val adapter = MessageListAdapter()
        //// Recupero el RV de Pantalla
        val recyclerView = binding.messageList
        //// Lo configuro para scroll vertical
        recyclerView.layoutManager = LinearLayoutManager(context)
        //// Asocio el adaptador al reciclerview
        recyclerView.adapter = adapter
        ///
        adapter.submitList(messageRepository.message.filter {
            it.id == id // preguntar david para  que servia
        })
        ///configuramos botón de mensaje
        binding.bttnSend.setOnClickListener {
            sendMessage(it)
        }



    }
}