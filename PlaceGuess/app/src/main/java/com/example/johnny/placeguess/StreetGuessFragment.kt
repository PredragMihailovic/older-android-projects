package com.example.johnny.placeguess

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.johnny.placeguess.datamodel.LocationsDataModel
import com.example.johnny.placeguess.pojos.Location
import com.example.johnny.placeguess.utils.Constant
import com.example.johnny.placeguess.utils.HelperClass
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback
import com.google.android.gms.maps.StreetViewPanorama
import com.google.android.gms.maps.StreetViewPanoramaView
import com.google.android.gms.maps.model.LatLng
import com.squareup.picasso.Picasso
import com.google.android.gms.maps.model.StreetViewPanoramaCamera




class StreetGuessFragment : Fragment(), OnStreetViewPanoramaReadyCallback {

    private var listener: OnStreetGuessFragmentInteractionListener? = null

    private lateinit var secondsTextView: TextView
    private lateinit var streetView: StreetViewPanoramaView
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
        val view = inflater.inflate(R.layout.fragment_street_guess, container, false)

        setViews(view)
        streetView.getStreetViewPanoramaAsync(this)
        streetView.onCreate(savedInstanceState)
        streetView.onResume()

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

        }else {
            listener?.noMoreAvailableLocations(score)
        }
    }

    override fun onStreetViewPanoramaReady(p0: StreetViewPanorama?) {
        val coords = location!!.coordinates
        p0!!.setPosition(LatLng(coords.latitude, coords.longitude))

        val duration: Long = 1000
        val camera = StreetViewPanoramaCamera.Builder()
                .zoom(p0.getPanoramaCamera().zoom)
                .tilt(p0.getPanoramaCamera().tilt)
                .bearing(p0.getPanoramaCamera().bearing - 60)
                .build()
        p0.animateTo(camera, duration)


    }

    private fun setViews(view: View){
        secondsTextView = view.findViewById(R.id.secondsStreetGuess)
        scoreTextView = view.findViewById(R.id.currentScoreStreetGuess)
        streetView = view.findViewById(R.id.streetView)
        homeButton = view.findViewById(R.id.toolbarHomeButton)

        homeButton.setOnClickListener {
            HelperClass.goToFragmentTag(activity!!, Constant.FragmentTag.HOME_TAG)
        }

        secondsCounter(Constant.MilisecondsAllowed.STREET_MILISECONDS)
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
        if (context is OnStreetGuessFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnStreetGuessFragmentInteractionListener {
        fun timerFinishedPassLocationToMap(location: Location)
        fun noMoreAvailableLocations(score: Int)
    }
    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = StreetGuessFragment()
    }
}
