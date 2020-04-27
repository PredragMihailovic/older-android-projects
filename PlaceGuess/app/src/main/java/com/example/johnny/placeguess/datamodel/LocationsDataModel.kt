package com.example.johnny.placeguess.datamodel

import com.example.johnny.placeguess.pojos.*
import com.example.johnny.placeguess.utils.Constant
import com.google.android.gms.maps.model.LatLng

class LocationsDataModel(val type: Int = 0) {

    private val locations = mutableListOf<Location>()


    init {
        when(type) {
            Constant.GuessType.MONUMENT_TYPE -> addMonuments()
            Constant.GuessType.STREET_VIEW_TYPE -> addStreets()
            Constant.GuessType.CITY_TYPE -> addCities()
            Constant.GuessType.NATURAL_SITE_TYPE -> addNaturalSites()
        }

        locations.shuffle()
    }

    private fun addMonuments(){

        locations.add(Monument("Great Pyramid of Giza", "Egypt",
         LatLng(29.979241, 31.133586),
         "http://s.newsweek.com/sites/www.newsweek.com/files/styles/full/public/2018/02/20/gettyimages-918637914.jpg"))

        locations.add(Monument( "Machu Picchu", "Peru",
        LatLng( -13.163350, -72.544974),
         "https://www.nationalgeographic.com/content/dam/science/photos/000/247/24713.ngsversion.1491231602188.adapt.1900.1.jpg"))

        locations.add(Monument( "Potala Palace", "Tibet, China",
        LatLng( 29.655446, 91.118351),
         "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/%E5%B8%83%E8%BE%BE%E6%8B%89%E5%AE%AB.jpg/1200px-%E5%B8%83%E8%BE%BE%E6%8B%89%E5%AE%AB.jpg"))

        locations.add(Monument( "Old City (Jerusalem)",  "Israel",
        LatLng( 31.777291, 35.232159),
         "https://www.itraveljerusalem.com/wp-content/uploads/2016/07/sld-plh-crd-dreamstimes-jerusalem-old-city-landscape-1.jpg"))

        locations.add(Monument("Chichen Itza Pyramid",  "Mexico",
        LatLng( 20.684368, -88.568119),
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Chichen_Itza_3.jpg/2560px-Chichen_Itza_3.jpg"))

        locations.add(Monument( "Neuschwanstein Castle",  "Germany",
        LatLng( 47.557574, 10.749639),
         "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Ftrevornace%2Ffiles%2F2015%2F11%2FNeuschwanstein-Castle-Germany-1200x896.jpg"))
    }

    private fun addCities(){
        locations.add(City( "New York",  "USA",
        LatLng(40.735662, -73.954995),
         "https://www.jumbo.rs/wp-content/uploads/2015/03/new-york-1024x636.jpg"))

        locations.add(City("Belgrade",  "Serbia",
                LatLng( 44.799314, 20.507710),
         "http://www.tob.rs/images/slider/City%20Break%201.jpg"))

        locations.add(City( "Zurich", "Switzerland",
                LatLng( 47.391613,  8.532593),
         "https://lonelyplanetwp.imgix.net/2018/01/shutterstock_Nataliya_Hora-zurich_mini-c8f7c1539f2e.jpg?fit=min&q=40&sharp=10&vib=20&w=1470"))

        locations.add(City( "Verona",  "Italy",
                LatLng( 45.41924, 10.983946),
         "https://www.10cose.it/wp-content/uploads/2015/09/verona-696x305.jpg"))

        locations.add(City( "Strasbourg", "France",
        LatLng( 48.583630, 7.737373),
         "https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/09/12/16/strasbourg-petite-france.jpg?w968h681"))

    }

    private fun addNaturalSites(){
        locations.add(NaturalSite( "Longsheng Rice Terraces", "China",
                LatLng( 25.771446, 109.978125),
         "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/LongshengRiceTerrace.jpg/1200px-LongshengRiceTerrace.jpg"))

        locations.add(NaturalSite( "Bora Bora", "French Polynesia",
                LatLng( -16.504092, -151.7396800),
        "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Ftrevornace%2Ffiles%2F2015%2F11%2Fbora-bora-French-Polynesia-1200x804.jpg"))

        locations.add(NaturalSite( "Victoria Falls", "Zambia/Zimbabwe",
                LatLng(-17.924654,25.856438),
         "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Ftrevornace%2Ffiles%2F2015%2F11%2Fvictoria-falls-1200x1001.jpg"))

        locations.add(NaturalSite( "Torres Del Paine Patagonia","Chile",
                LatLng( -50.966451, -73.406331),
        "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Ftrevornace%2Ffiles%2F2015%2F11%2Ftorres-del-paine-patagonia-1200x747.jpg"))

        locations.add(NaturalSite("Railay", "Thailand",
        LatLng( 8.012264, 98.834114),
        "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Ftrevornace%2Ffiles%2F2015%2F11%2Frailay-thailand-1200x832.jpg"))
    }

    private fun addStreets(){
        locations.add(Street( "New York", "USA",
                LatLng( 40.735662,  -73.954995),
        "https://www.jumbo.rs/wp-content/uploads/2015/03/new-york-1024x636.jpg"))

        locations.add(Street("Belgrade", "Serbia",
                LatLng(44.799314, 20.507710),
        "http://www.tob.rs/images/slider/City%20Break%201.jpg"))

        locations.add(Street("Zurich", "Switzerland",
                LatLng( 47.391613, 8.532593),
        "https://lonelyplanetwp.imgix.net/2018/01/shutterstock_Nataliya_Hora-zurich_mini-c8f7c1539f2e.jpg?fit=min&q=40&sharp=10&vib=20&w=1470"))

        locations.add(Street("Verona", "Italy",
                LatLng( 45.444975, 10.999348),
        "https://www.10cose.it/wp-content/uploads/2015/09/verona-696x305.jpg"))

        locations.add(Street("Strasbourg", "France",
        LatLng( 48.583630, 7.737373),
        "https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/09/12/16/strasbourg-petite-france.jpg?w968h681"))
    }

    val locationsSize: Int get() = locations.size

    fun getLocation() = locations.removeAt(locations.size - 1)



}