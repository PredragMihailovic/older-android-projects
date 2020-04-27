package com.example.johnny.placeguess

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.johnny.placeguess.pojos.Location
import com.example.johnny.placeguess.utils.Constant


class MainActivity : AppCompatActivity(), MapFragment.OnMapFragmentInteractionListener
        ,StreetGuessFragment.OnStreetGuessFragmentInteractionListener, ImageGuessFragment.OnImageGuessFragmentInteractionListener,
        HomeFragment.OnHomeFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setHomeFragment()
    }

    override fun timerFinishedPassLocationToMap(location: Location) {
        transactionToMap(location)
    }

    override fun noMoreAvailableLocations(score: Int) {
        transactionToGameFinished(score)
    }

    override fun updateScore(score: Int) {

        val fragment = supportFragmentManager.findFragmentByTag(Constant.FragmentTag.IMAGE_GUESS_TAG)

        if (fragment != null && fragment is ImageGuessFragment) {
            fragment.updateScore(score)
        }
        else {
            val streetFragment = supportFragmentManager.findFragmentByTag(Constant.FragmentTag.STREET_GUESS_TAG) as StreetGuessFragment
            streetFragment.updateScore(score)
        }

    }

    fun setHomeFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, HomeFragment())
                .addToBackStack(Constant.FragmentTag.HOME_TAG).commit()
    }

    fun transactionToMap(location: Location) {

        var fragment = MapFragment.newInstance()
        val bundle = Bundle()
        bundle.putParcelable(Constant.BundleKey.GUESS_LOCATION_TO_MAP_KEY, location as Parcelable)

        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment)
                .addToBackStack(null).commit()
    }

    fun transactionToGameFinished(score: Int){

        val fragment = GameFinishedFragment.newInstance()
        val bundle = Bundle()

        bundle.putInt(Constant.BundleKey.FINAL_SCORE_KEY, score)

        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment)
                .addToBackStack(null).commit()
    }

    override fun imageClicked(id: Int) {
        addFragment(id)
    }

    override fun onBackPressed() {

    }

    private fun addFragment(id: Int){

        var fragment = Fragment()
        var bundle = Bundle()
        var tag: String? = null

        when(id) {
            R.id.monumentImage -> {
                fragment = ImageGuessFragment.newInstance()
                bundle.putInt(Constant.BundleKey.GUESS_TYPE_KEY, Constant.GuessType.MONUMENT_TYPE)
                tag = Constant.FragmentTag.IMAGE_GUESS_TAG
            }
            R.id.streetImage -> {
                fragment = StreetGuessFragment.newInstance()
                bundle.putInt(Constant.BundleKey.GUESS_TYPE_KEY, Constant.GuessType.STREET_VIEW_TYPE)
                tag = Constant.FragmentTag.STREET_GUESS_TAG
            }
            R.id.cityImage -> {
                fragment = ImageGuessFragment.newInstance()
                bundle.putInt(Constant.BundleKey.GUESS_TYPE_KEY, Constant.GuessType.CITY_TYPE)
                tag = Constant.FragmentTag.IMAGE_GUESS_TAG
            }
            R.id.naturalSiteImage -> {
                fragment = ImageGuessFragment.newInstance()
                bundle.putInt(Constant.BundleKey.GUESS_TYPE_KEY, Constant.GuessType.NATURAL_SITE_TYPE)
                tag = Constant.FragmentTag.IMAGE_GUESS_TAG
            }
        }
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment, tag)
                .addToBackStack(null).commit()
    }

}
