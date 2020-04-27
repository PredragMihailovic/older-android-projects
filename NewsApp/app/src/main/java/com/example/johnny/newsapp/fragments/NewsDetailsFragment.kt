package com.example.johnny.newsapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.example.johnny.newsapp.Constant
import com.example.johnny.newsapp.R
import com.example.johnny.newsapp.pojos.News
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_news_details.view.*

class NewsDetailsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news_details, container, false)

        val news = arguments!!.getParcelable<News>(Constant.NEWS_BUNDLE_KEY)

        setActionBar(view)
        setViews(view, news)

        return view
    }

    private fun setActionBar(view: View){
        val toolbar = view.findViewById<Toolbar>(R.id.newsDetailsToolbar)
        setHasOptionsMenu(true)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar.apply {
            this!!.setDisplayHomeAsUpEnabled(true)
            this!!.setDisplayShowHomeEnabled(true)
        }
    }

    private fun setViews(view: View, news: News){
        view.newsDetailsUrl.text = "Site source: ".plus(news.url)
        view.newsDetailsTitle.text = news.title
        view.newsDetailsDescription.text = "News description: ".plus(news.description)
        view.newsDetailsDate.text = news.publishedAt

        Picasso.get().load(news.urlToImage).placeholder(R.drawable.progress_animation).into(view.newsDetailsImageView)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if(id == android.R.id.home){
            activity!!.supportFragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance(): Fragment {
            return NewsDetailsFragment()
        }
    }

}