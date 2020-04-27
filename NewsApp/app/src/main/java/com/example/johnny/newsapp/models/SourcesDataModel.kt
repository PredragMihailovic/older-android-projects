package com.example.johnny.newsapp.models

import com.example.johnny.newsapp.pojos.Source

class SourcesDataModel {

    private var sources: Array<Source>

    init{
        sources = arrayOf(
            Source("ABC News", "https://icon-locator.herokuapp.com/icon?url=http://abcnews.go.com&size=70..120..200", "abc-news"),
            Source("Aftenposten", "https://icon-locator.herokuapp.com/icon?url=https://www.aftenposten.no&size=70..120..200", "aftenposten"),
            Source("Al Jazeera English", "https://icon-locator.herokuapp.com/icon?url=http://www.aljazeera.com&size=70..120..200", "al-jazeera-english"),
            Source("ANSA.it", "https://icon-locator.herokuapp.com/icon?url=http://www.ansa.it&size=70..120..200", "ansa"),
            Source("Ars Technica", "https://icon-locator.herokuapp.com/icon?url=http://arstechnica.com&size=70..120..200", "ars-technica"),
            Source( "Axios", "https://icon-locator.herokuapp.com/icon?url=https://www.axios.com&size=70..120..200", "axios"),
            Source("BBC News", "https://icon-locator.herokuapp.com/icon?url=http://www.bbc.co.uk/news&size=70..120..200", "bbc-news"),
            Source("BBC Sport", "https://icon-locator.herokuapp.com/icon?url=http://www.bbc.co.uk/sport&size=70..120..200", "bbc-sport"),
            Source("Bild", "https://icon-locator.herokuapp.com/icon?url=http://www.bild.de&size=70..120..200", "bild"),
            Source("Bloomberg", "https://icon-locator.herokuapp.com/icon?url=http://www.bloomberg.com&size=70..120..200", "bloomberg"),
            Source("Business Insider", "https://icon-locator.herokuapp.com/icon?url=http://www.businessinsider.com&size=70..120..200", "business-insider"),
            Source("CBC News", "https://icon-locator.herokuapp.com/icon?url=http://www.cbc.ca/news&size=70..120..200", "cbc-news"),
            Source("CNN", "https://icon-locator.herokuapp.com/icon?url=http://us.cnn.com&size=70..120..200", "cnn"),
            Source("Crypto Coins News", "https://icon-locator.herokuapp.com/icon?url=https://www.ccn.com&size=70..120..200", "crypto-coins-news"),
            Source("Daily Mail", "https://icon-locator.herokuapp.com/icon?url=http://www.dailymail.co.uk/home/index.html&size=70..120..200", "daily-mail"),
            Source("El Mundo", "https://icon-locator.herokuapp.com/icon?url=http://www.elmundo.es&size=70..120..200", "el-mundo"),
            Source("ESPN", "https://icon-locator.herokuapp.com/icon?url=http://espn.go.com&size=70..120..200", "espn"),
            Source("Financial Post", "https://icon-locator.herokuapp.com/icon?url=http://business.financialpost.com&size=70..120..200", "financial-post"),
            Source("Fox News", "https://icon-locator.herokuapp.com/icon?url=http://www.foxnews.com&size=70..120..200", "fox-news"),
            Source("Fortune", "https://icon-locator.herokuapp.com/icon?url=http://fortune.com&size=70..120..200", "fortune"),
            Source("Fox Sports", "https://icon-locator.herokuapp.com/icon?url=http://www.foxsports.com&size=70..120..200", "fox-sports"),
            Source("Google News", "https://icon-locator.herokuapp.com/icon?url=https://news.google.com&size=70..120..200", "google-news"),
            Source("Independent", "https://icon-locator.herokuapp.com/icon?url=http://www.independent.co.uk&size=70..120..200", "independent"),
            Source("InfoMoney", "https://icon-locator.herokuapp.com/icon?url=http://www.infomoney.com.br&size=70..120..200", "info-money"),
            Source("La Gaceta", "https://icon-locator.herokuapp.com/icon?url=http://www.lagaceta.com.ar&size=70..120..200", "la-gaceta"),
            Source("Marca", "https://icon-locator.herokuapp.com/icon?url=http://www.marca.com&size=70..120..200", "marca"),
            Source("Mirror", "https://icon-locator.herokuapp.com/icon?url=http://www.mirror.co.uk/&size=70..120..200", "mirror"),
            Source("MTV News", "https://icon-locator.herokuapp.com/icon?url=http://www.mtv.com/news&size=70..120..200",  "mtv-news"),
            Source("National Geographic", "https://icon-locator.herokuapp.com/icon?url=http://news.nationalgeographic.com&size=70..120..200", "national-geographic"),
            Source("New Scientist", "https://icon-locator.herokuapp.com/icon?url=https://www.newscientist.com/section/news&size=70..120..200", "new-scientist"),
            Source("Reddit", "https://icon-locator.herokuapp.com/icon?url=https://www.reddit.com/r/all&size=70..120..200", "reddit-r-all"),
            Source( "Reuters", "https://icon-locator.herokuapp.com/icon?url=http://www.reuters.com&size=70..120..200", "reuters"),
            Source( "Spiegel Online", "https://icon-locator.herokuapp.com/icon?url=http://www.spiegel.de&size=70..120..200", "spiegel-online"),
            Source( "TechCrunch", "https://icon-locator.herokuapp.com/icon?url=https://techcrunch.com&size=70..120..200", "techcrunch"),
            Source( "TechRadar", "https://icon-locator.herokuapp.com/icon?url=http://www.techradar.com&size=70..120..200", "techradar"),
            Source( "The Economist", "https://icon-locator.herokuapp.com/icon?url=http://www.economist.com&size=70..120..200", "the-economist"),
            Source( "The Guardian (UK)", "https://icon-locator.herokuapp.com/icon?url=https://www.theguardian.com/uk&size=70..120..200", "the-guardian-uk"),
            Source( "The Lad Bible", "https://icon-locator.herokuapp.com/icon?url=http://www.theladbible.com&size=70..120..200",  "the-lad-bible"),
            Source( "The New York Times","https://icon-locator.herokuapp.com/icon?url=http://www.nytimes.com&size=70..120..200", "the-new-york-times"),
            Source( "The Next Web", "https://icon-locator.herokuapp.com/icon?url=http://thenextweb.com&size=70..120..200", "the-next-web"),
            Source( "The Sport Bible", "https://icon-locator.herokuapp.com/icon?url=http://www.thesportbible.com&size=70..120..200", "the-sport-bible"),
            Source( "The Telegraph", "https://icon-locator.herokuapp.com/icon?url=http://www.telegraph.co.uk&size=70..120..200", "the-telegraph"),
            Source( "The Wall Street Journal", "https://icon-locator.herokuapp.com/icon?url=http://www.wsj.com&size=70..120..200", "the-wall-street-journal"),
            Source( "Time", "https://icon-locator.herokuapp.com/icon?url=http://time.com&size=70..120..200", "time"),
            Source( "Vice News", "https://icon-locator.herokuapp.com/icon?url=https://news.vice.com&size=70..120..200", "vice-news"))

    }

    val sourcesData get() = sources

}