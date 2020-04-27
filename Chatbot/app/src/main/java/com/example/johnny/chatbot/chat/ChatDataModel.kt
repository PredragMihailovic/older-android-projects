package com.example.johnny.chatbot.chat

import ai.api.android.AIService
import ai.api.model.AIRequest
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.johnny.chatbot.Constant
import java.util.*
import kotlin.concurrent.thread

class ChatViewModel: ViewModel() {

    private val _messages = MutableLiveData<MutableList<Message>>()

    init {
        _messages.value = mutableListOf()
    }

    fun sendTextToApiAI(text: String, aiService: AIService){
        val request = AIRequest()

        request.setQuery(text)

        thread {
            val response = aiService!!.textRequest(request)

            val messageBody = response.result.fulfillment.speech
            val message = Message(Sender(Constant.BotData.BOT_USERNAME, Constant.BotData.BOT_IMAGE_URL),
                    MessageKind.RECEPIENT, messageBody, Date())

            addMessage(message, aiService)
        }
    }

    val messages: LiveData<MutableList<Message>> get() = _messages

    fun addMessage(message: Message, aiService: AIService) {
        _messages.value!!.add(message)
        if(message.messageKind == MessageKind.SENDER) sendTextToApiAI(message.messageBody, aiService)
    }
}