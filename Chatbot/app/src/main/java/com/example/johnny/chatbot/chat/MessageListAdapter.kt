package com.example.johnny.chatbot.chat

import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.johnny.chatbot.R
import kotlinx.android.synthetic.main.message_list_item.view.*
import android.widget.FrameLayout
import com.example.johnny.chatbot.Utils


class MessageListAdapter(private val data: List<Message>, private val context: FragmentActivity): RecyclerView.Adapter<MessageListAdapter.ViewHolder>() {


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val date = data[position].date
        val time = Utils.getTimeFromDate(date)

        holder.view.chatItemTime.text = time
        holder.view.chatItemMessage.text = data[position].messageBody

        val kind = data[position].messageKind

        when (kind) {
            MessageKind.RECEPIENT -> setView(holder, R.drawable.received_message, Gravity.LEFT)
            MessageKind.SENDER -> setView(holder, R.drawable.sending_message, Gravity.RIGHT)
        }
    }

    private fun setView(holder: ViewHolder, resource: Int, gravity: Int){
        holder.view.chatListItem.background = ContextCompat.getDrawable(context, resource);

        val layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.gravity = gravity
        holder.view.chatListItem.layoutParams = layoutParams
    }


}