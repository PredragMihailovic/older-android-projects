package com.example.johnny.newsapp

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class Utils {

    companion object {
        fun dateFormatter(date: String): String{
            var newDate = date.replace("-", ".")
            newDate = newDate.replace("T", " at: ")
            newDate = newDate.replace("Z", " ")

            return newDate
        }
    }

    object PreferenceHelper {

        fun getSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(Constant.PREFS_NAME, Constant.PREFS_CODE)
        }

        fun getCountryCode(context: Context): String{
            return getSharedPreferences(context).getString(Constant.PREFS_COUNTRY_KEY, "rs")
        }

    }

}

