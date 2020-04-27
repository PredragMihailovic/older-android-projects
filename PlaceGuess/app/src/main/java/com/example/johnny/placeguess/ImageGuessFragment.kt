package com.example.johnny.placeguess

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.example.johnny.placeguess.datamodel.LocationsDataModel
import com.example.johnny.placeguess.pojos.Location
import com.example.johnny.placeguess.utils.Constant
import com.example.johnny.placeguess.utils.HelperClass
import com.squareup.picasso.Picasso


class ImageGuessFragment : Fragment() {

    private var listener: OnImageGuessFragmentInteractionListener? = null
    private lateinit var secondsTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var scoreTextView: TextView
    private lateinit var homeButton: Button

    private var model: LocationsDataModel? = null
    private var location: Location? = null

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            val type = it.getInt(Constant.BundleKey.GUESS_TYPE_KEY)
            model = LocationsDataModel(type)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_image_guess, container, false)

        setViews(view)

        return view
    }

    fun updateScore(score: Int){
        this.score += score
    }

    override fun onResume() {
        super.onResume()

        scoreTextView.text = "Current score: ".plus(score)

        if (model!!.locationsSize > 0) {
            location = model!!.getLocation()
            Picasso.get().load(location!!.imageUrl).into(imageView)

        }else {
            listener?.noMoreAvailableLocations(score)
        }
    }

    private fun setViews(view: View){
        secondsTextView = view.findViewById(R.id.secondsImageGuess)
        scoreTextView = view.findViewById(R.id.scoreImageGuess)
        imageView = view.findViewById(R.id.imageImageGuess)
        homeButton = view.findViewById(R.id.toolbarHomeButton)

        homeButton.setOnClickListener {
            HelperClass.goToFragmentTag(activity!!, Constant.FragmentTag.HOME_TAG)
        }

        secondsCounter(Constant.MilisecondsAllowed.IMAGE_MILISECONDS)
    }

    private fun secondsCounter(num: Long) {

        object : CountDownTimer(num, 1000) {

            override fun onTick(secondsUntilDone: Long) {
                secondsTextView.text = (secondsUntilDone/1000).toString()
            }

            override fun onFinish() {
                listener?.timerFinishedPassLocationToMap(location!!)
            }
        }.start()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnImageGuessFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnImageGuessFragmentInteractionListener {
        fun timerFinishedPassLocationToMap(location: Location)
        fun noMoreAvailableLocations(score: Int)
    }

    companion object {

        @JvmStatic
        fun newInstance(): Fragment {
            return ImageGuessFragment()
        }

    }
}
