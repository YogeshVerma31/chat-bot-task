package com.sariaydinalparslan.chatbotkotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sariaydinalparslan.chatbotkotlin.R
import com.sariaydinalparslan.chatbotkotlin.data.Message
import com.yogesh.chatresponse.Constants.RECEIVE_ID
import com.yogesh.chatresponse.Constants.SEND_ID

class MessagingAdapter : RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messageList = mutableListOf<Message>()

    inner class MessageViewHolder ( itemView : View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
               messageList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item,parent,false))
    }
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
       val currentMessage = messageList[position]
        when (currentMessage.id){
            SEND_ID ->{
                holder.itemView.findViewById<TextView>(R.id.tv_message).apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<TextView>(R.id.tv_bot_message).visibility = View.GONE
            }
            RECEIVE_ID ->{
                holder.itemView.findViewById<TextView>(R.id.tv_bot_message).apply {
                    text=currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<TextView>(R.id.tv_message).visibility = View.GONE
            }
        }
    }
    override fun getItemCount(): Int {
       return messageList.size
    }
    fun insertMessage (message: Message){
        this.messageList.add(message)
        notifyItemInserted(messageList.size)
        notifyDataSetChanged()
    }
}