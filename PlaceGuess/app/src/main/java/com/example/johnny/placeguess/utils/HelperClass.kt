package com.example.johnny.placeguess.utils

import android.support.v4.app.FragmentActivity

class HelperClass {

    companion object {
        fun goToFragmentTag(activity: FragmentActivity, tag: String){
            activity!!.supportFragmentManager.popBackStack(tag, 0)
        }
    }

}