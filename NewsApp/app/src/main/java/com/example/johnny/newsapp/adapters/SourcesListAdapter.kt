package com.example.johnny.newsapp.adapters

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.johnny.newsapp.Constant
import com.example.johnny.newsapp.R
import com.example.johnny.newsapp.fragments.CountryListFragment
import com.example.johnny.newsapp.fragments.SourceNewsFragment
import com.example.johnny.newsapp.models.NewsViewModel
import com.example.johnny.newsapp.pojos.Country
import com.example.johnny.newsapp.pojos.Source
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_list_item.view.*
import kotlinx.android.synthetic.main.source_list_item.view.*

class SourcesListAdapter( val data: Array<Source>, val context: AppCompatActivity): RecyclerView.Adapter<SourcesListAdapter.ViewHolder>()
        , View.OnClickListener{


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.source_list_item, parent, false)

        view.setOnClickListener(this)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.view.tag = position

        holder.view.sourceListTitle.text = data[position].name
        Picasso.get().load(data[position].imageUrl).placeholder(R.drawable.progress_animation).into(holder.view.sourceListImageView)


    }

    override fun onClick(p0: View?) {
        val result = data.get(p0!!.tag as Int)

        val fragment = SourceNewsFragment()

        val b = Bundle()
        b.putString(Constant.SOURCE_CODE_KEY, result.code)
        b.putString(Constant.SOURCE_URL_KEY, result.imageUrl)

        fragment.arguments = b

        context.supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, fragment)
                .addToBackStack(null).commit()
    }


}
