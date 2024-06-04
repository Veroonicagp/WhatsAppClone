package com.alanturing.cpifp.whatsappclone.main.chat.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alanturing.cpifp.whatsappclone.main.chat.data.Chat
import com.alanturing.cpifp.whatsappclone.databinding.ChatListItemBinding

class ChatListAdapter(private val toChat: (View, Chat)-> Unit) :ListAdapter<Chat, ChatListAdapter.ChatListItemViewHolder>(
    ChatDiff
) {

    inner class ChatListItemViewHolder(private val binding: ChatListItemBinding): ViewHolder(binding.root){
        fun bindTo(chat: Chat){
            binding.nombre.text = chat.toName
            binding.root.setOnClickListener{
                toChat(binding.root,chat)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListItemViewHolder {
       val binding:ChatListItemBinding = ChatListItemBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       )
        return ChatListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatListItemViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    object ChatDiff: DiffUtil.ItemCallback<Chat>(){
        override fun areItemsTheSame(oldItem: Chat, newItem: Chat) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Chat, newItem: Chat) = oldItem.to == newItem.to

    }



}