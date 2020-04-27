package com.example.johnny.chatbot

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class HomeFragment : Fragment() {

    private lateinit var speakToMeButton: Button

    private var listener: OnHomeFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        speakToMeButton = view.findViewById(R.id.speakToMeButton)
        speakToMeButton.setOnClickListener {
            listener?.speakButtonClicked()
        }

        return view
    }

    interface OnHomeFragmentInteractionListener {
        fun speakButtonClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnHomeFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        fun newInstance(): Fragment = HomeFragment()
    }
}
