package com.example.johnny.chatbot

import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {
        fun getTimeFromDate(date: Date): String{
            val sdf = SimpleDateFormat("HH:mm")

            val time = sdf.format(date)

            return time
        }
    }
}