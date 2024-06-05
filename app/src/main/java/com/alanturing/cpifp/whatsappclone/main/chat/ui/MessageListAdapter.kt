package com.alanturing.cpifp.whatsappclone.main.chat.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alanturing.cpifp.whatsappclone.core.network.MessageResponse
import com.alanturing.cpifp.whatsappclone.main.chat.data.Message
import com.alanturing.cpifp.whatsappclone.databinding.MessageListItemBinding

class MessageListAdapter(): ListAdapter<Message, MessageListAdapter.MessageListItemViewHolder>(
    MessageDiff
){

    inner class MessageListItemViewHolder(private val binding:MessageListItemBinding):ViewHolder(binding.root){
        fun bindTo(message: Message){
            binding.txtMssg.text = message.text
            binding.dateTime.text = message.datetime.toString()
        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageListItemViewHolder {
        val binding = MessageListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MessageListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageListItemViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }



    object MessageDiff: DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message):Boolean {
            return ((oldItem.id==newItem.id)&&(oldItem.datetime?.epochSeconds==newItem.datetime?.epochSeconds))///¿?
        }

        override fun areContentsTheSame(oldItem: Message, newItem: Message) = oldItem == newItem

    }

}