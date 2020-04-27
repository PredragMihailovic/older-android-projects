package com.example.johnny.placeguess.utils

class Constant {

    object GuessType {
        val MONUMENT_TYPE = 0
        val STREET_VIEW_TYPE = 1
        val CITY_TYPE = 2
        val NATURAL_SITE_TYPE = 3
    }

    object BundleKey {
        val GUESS_TYPE_KEY = "guessTypeKey"
        val GUESS_LOCATION_TO_MAP_KEY = "guessLocationToMapKey"
        val FINAL_SCORE_KEY = "finalScoreKey"
    }

    object FragmentTag {
        val IMAGE_GUESS_TAG = "imageGuessFragmentTag"
        val STREET_GUESS_TAG = "streetGuessFragmentTag"
        val HOME_TAG = "homeFragmentTag"
    }

    object API {
        val KEY = "AIzaSyDWi8AJYKUVjscxLwnQgUISaeBVEbcqWqU"
    }

    object MilisecondsAllowed {
        val IMAGE_MILISECONDS = 10000L
        val STREET_MILISECONDS = 15000L
    }

    object ScorePoints {
        val DISTANCE_LESS_THAN_1000 = 100
        val DISTANCE_LESS_THAN_1500 = 50
        val DISTANCE_LESS_THAN_2000 = 40
        val DISTANCE_LESS_THAN_2500 = 20
        val DISTANCE_LESS_THAN_3000 = 5
        val DISTANCE_GREATER_THAN_3000 = 0
    }

}
