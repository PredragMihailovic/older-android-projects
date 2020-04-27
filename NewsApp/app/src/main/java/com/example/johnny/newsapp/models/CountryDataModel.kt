package com.example.johnny.newsapp.models

import com.example.johnny.newsapp.pojos.Country
import com.example.johnny.newsapp.repository.NewsRepository

class CountryDataModel {

    private var countries: Array<Country>



    init {


         countries = arrayOf(
                Country( "Australia", "http://flags.fmcdn.net/data/flags/h160/au.png","au"),
                Country( "Austria", "http://flags.fmcdn.net/data/flags/h160/at.png", "at" ),
                Country( "Brazil", "http://flags.fmcdn.net/data/flags/h160/br.png", "br"),
                Country("Canada", "http://flags.fmcdn.net/data/flags/h160/ca.png", "ca"),
                Country("Cuba", "http://flags.fmcdn.net/data/flags/h160/cu.png", "cu"),
                Country("Czech Republic", "http://flags.fmcdn.net/data/flags/h160/cz.png", "cz"),
                Country("France", "http://flags.fmcdn.net/data/flags/h160/fr.png", "fr"),
                Country( "Greece", "http://flags.fmcdn.net/data/flags/h160/gr.png","gr"),
                Country( "Israel", "http://flags.fmcdn.net/data/flags/h160/il.png", "il"),
                Country("Italy", "http://flags.fmcdn.net/data/flags/h160/it.png", "it"),
                Country("Japan", "http://flags.fmcdn.net/data/flags/h160/jp.png", "jp"),
                Country("Netherlands", "http://flags.fmcdn.net/data/flags/h160/nl.png",  "nl"),
                Country("New Zaeland", "http://flags.fmcdn.net/data/flags/h160/nz.png", "nz"),
                Country("Norway", "http://flags.fmcdn.net/data/flags/h160/no.png", "no"),
                Country("Portugal", "http://flags.fmcdn.net/data/flags/h160/pt.png", "pt"),
                Country("Russia", "http://flags.fmcdn.net/data/flags/h160/ru.png", "ru"),
                Country("Serbia", "http://flags.fmcdn.net/data/flags/h160/rs.png", "rs"),
                Country("Slovenia", "http://flags.fmcdn.net/data/flags/h160/si.png", "si"),
                Country( "Switzerland", "http://flags.fmcdn.net/data/flags/h160/ch.png", "ch"),
                Country("UAE", "http://flags.fmcdn.net/data/flags/h160/ae.png", "ae"),
                Country("United Kingdom", "http://flags.fmcdn.net/data/flags/h160/gb.png", "gb"),
                Country("United States", "http://flags.fmcdn.net/data/flags/h160/us.png", "us"))


    }

    val countriesData get() = countries

}