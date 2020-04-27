package com.example.johnny.placeguess.utils

import android.location.Location

class ScoreMeasure {

    companion object {

        fun getScore(distance: Float): Int{
            return scored(distance)
        }

        private fun scored(distance: Float): Int{
            if (distance <= 1000) {
                return Constant.ScorePoints.DISTANCE_LESS_THAN_1000
            }
            else if (distance <= 1500) {
                return Constant.ScorePoints.DISTANCE_LESS_THAN_1500
            }
            else if (distance <= 2000) {
                return Constant.ScorePoints.DISTANCE_LESS_THAN_2000
            }
            else if (distance <= 2500) {
                return Constant.ScorePoints.DISTANCE_LESS_THAN_2500
            }
            else if (distance <= 3000) {
                return Constant.ScorePoints.DISTANCE_LESS_THAN_3000
            }else {
                return Constant.ScorePoints.DISTANCE_GREATER_THAN_3000
            }
        }

        fun getDistanceBetween(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Float{
            val results = FloatArray(3)

            Location.distanceBetween(lat1, lon1, lat2, lon2, results)

            val res = results[0]/1000 // in kms

            return res
        }

    }

}