package com.example.johnny.chatbot.chat

import java.util.*

data class Message(val sender: Sender, val messageKind: MessageKind,
                   val messageBody: String, val date: Date)

data class Sender(val name: String, val imageUrl: String)

enum class MessageKind { RECEPIENT, SENDER }
