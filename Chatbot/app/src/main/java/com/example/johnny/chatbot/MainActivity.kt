package com.example.johnny.chatbot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.johnny.chatbot.chat.ChatFragment

class MainActivity : AppCompatActivity(), HomeFragment.OnHomeFragmentInteractionListener,
        ChatFragment.OnChatFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHomeFragment()
    }

    override fun popToHomeFragment(){
        popFromBackstackFragment()
    }

    override fun speakButtonClicked() {
        replaceFragment(ChatFragment.newInstance())
    }

    private fun replaceFragment(fragment: Fragment){
        this.supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit()
    }

    private fun setHomeFragment(){
        replaceFragment(HomeFragment.newInstance())
    }

    private fun popFromBackstackFragment(){
        this.supportFragmentManager.popBackStack()
    }
}
