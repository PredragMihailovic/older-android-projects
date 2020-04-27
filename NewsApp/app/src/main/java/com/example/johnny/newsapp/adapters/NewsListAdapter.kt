package com.example.johnny.newsapp.adapters

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.johnny.newsapp.Constant
import com.example.johnny.newsapp.R
import com.example.johnny.newsapp.Utils
import com.example.johnny.newsapp.fragments.NewsDetailsFragment
import com.example.johnny.newsapp.pojos.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_item.view.*

class NewsListAdapter(private val data: List<News>?, private val context: FragmentActivity): RecyclerView.Adapter<NewsListAdapter.ViewHolder>()
        , View.OnClickListener {


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_item, parent, false)

        view.setOnClickListener(this)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (data != null) {
            return data.size
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(data != null) {
            holder.view.tag = position

            holder.view.newsListTitle.text = data[position].title
            holder.view.newsListDate.text = Utils.dateFormatter(data[position].publishedAt)

            if(data[position].urlToImage == null || data[position].urlToImage.isEmpty()) {
                holder.view.newsListImageView.setImageResource(R.drawable.news_icon)
            }else {
                Picasso.get().load(data[position].urlToImage)
                        .placeholder(R.drawable.progress_animation).into(holder.view.newsListImageView)
            }
        }
    }

    override fun onClick(p0: View?) {

        if(data != null) {
            val row = (p0!!.tag as Int)
            val result = data[row]

            val fragment = NewsDetailsFragment()

            val b = Bundle()
            b.putParcelable(Constant.NEWS_BUNDLE_KEY, result)
            fragment.arguments = b

            context.supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, fragment)
                    .addToBackStack(null).commit()
        }
    }

}
