package com.example.johnny.placeguess


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var monumentImage: ImageView
    private lateinit var streetImage: ImageView
    private lateinit var cityImage: ImageView
    private lateinit var naturalSiteImage: ImageView

    private var listener: OnHomeFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        setViewsAndListeners(view)

        return view
    }

    private fun setViewsAndListeners(view: View){

        monumentImage = view.findViewById(R.id.monumentImage)
        streetImage = view.findViewById(R.id.streetImage)
        cityImage = view.findViewById(R.id.cityImage)
        naturalSiteImage = view.findViewById(R.id.naturalSiteImage)

        monumentImage.setOnClickListener(this)
        streetImage.setOnClickListener(this)
        cityImage.setOnClickListener(this)
        naturalSiteImage.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0!!.id
        listener!!.imageClicked(id)
    }

    interface OnHomeFragmentInteractionListener {
        fun imageClicked(id: Int)
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
}



