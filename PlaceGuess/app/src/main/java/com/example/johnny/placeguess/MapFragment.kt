package com.example.johnny.placeguess

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.johnny.placeguess.pojos.Location
import com.example.johnny.placeguess.pojos.Monument
import com.example.johnny.placeguess.utils.Constant
import com.example.johnny.placeguess.utils.HelperClass
import com.example.johnny.placeguess.utils.ScoreMeasure
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(), OnMapReadyCallback {

    private var listener: OnMapFragmentInteractionListener? = null
    private lateinit var mapView: MapView
    private lateinit var submitButton: FloatingActionButton
    private lateinit var homeButton: Button

    private var location: Location? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        arguments?.let {
            location = it.getParcelable<Monument>(Constant.BundleKey.GUESS_LOCATION_TO_MAP_KEY)
        }

        setViews(view)

        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)

        return view
    }

    private fun setViews(view: View){
        submitButton = view.findViewById(R.id.mapMapButton)
        mapView = view.findViewById(R.id.mapMapView)
        homeButton = view.findViewById(R.id.toolbarHomeButton)

        homeButton.setOnClickListener {
            HelperClass.goToFragmentTag(activity!!, Constant.FragmentTag.HOME_TAG)
        }
    }

    override fun onMapReady(p0: GoogleMap?) {
        p0!!.setOnMapClickListener(GoogleMap.OnMapClickListener {
            val lat = it.latitude
            val lon = it.longitude

            val markerOptions = MarkerOptions()

            markerOptions.position(it)

            p0.clear()
            p0.addMarker(markerOptions)

            submitButton.visibility = View.VISIBLE
            submitButton.setOnClickListener {

                val distance = ScoreMeasure.getDistanceBetween(lat, lon,
                        location!!.coordinates.latitude, location!!.coordinates.longitude)

                val score = ScoreMeasure.getScore(distance)

                listener?.updateScore(score)
                activity!!.supportFragmentManager.popBackStack()
            }

        })
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMapFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnMapFragmentInteractionListener {
        fun updateScore(score: Int)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MapFragment()
    }
}
