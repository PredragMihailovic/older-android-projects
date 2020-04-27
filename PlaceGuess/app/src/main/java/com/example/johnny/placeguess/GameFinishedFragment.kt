package com.example.johnny.placeguess

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.johnny.placeguess.utils.Constant
import com.example.johnny.placeguess.utils.HelperClass


class GameFinishedFragment : Fragment() {

    private lateinit var scoreTextView: TextView
    private lateinit var goHomeButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_game_finished, container, false)

        setViews(view)

        arguments?.let {
            val score = it.getInt(Constant.BundleKey.FINAL_SCORE_KEY)
            scoreTextView.text = "Your score is: ".plus(score)
        }

        return view
    }

    private fun setViews(view: View){
        scoreTextView = view.findViewById(R.id.gameFinishedScoreText)
        goHomeButton = view.findViewById(R.id.gameFinishedHomeButton)

        goHomeButton.setOnClickListener {
            HelperClass.goToFragmentTag(activity!!, Constant.FragmentTag.HOME_TAG)
        }
    }

    // Go home button clicked
    fun goHome(){
        activity!!.supportFragmentManager.popBackStack(Constant.FragmentTag.HOME_TAG, 0)
    }

    companion object {
        @JvmStatic
        fun newInstance() = GameFinishedFragment()
    }
}
