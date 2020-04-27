package com.example.johnny.newsapp.adapters

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.johnny.newsapp.Constant
import com.example.johnny.newsapp.R
import com.example.johnny.newsapp.Utils
import com.example.johnny.newsapp.pojos.Country
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_list_item.view.*

class CountryListAdapter(private val data: Array<Country>, val context: FragmentActivity): RecyclerView.Adapter<CountryListAdapter.ViewHolder>()
        ,View.OnClickListener{


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.country_list_item, parent, false)

        view.setOnClickListener(this)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.view.countryListTitle.text = data[position].name

        holder.view.tag = position

        val imageUrl = data[position].imageUrl

        Picasso.get().load(imageUrl).placeholder(R.drawable.progress_animation).into(holder.view.countryListImageView)
    }

    override fun onClick(p0: View?) {

        val pos = (p0!!.tag as Int)

        val code = data[pos].code

        var pref = Utils.PreferenceHelper.getSharedPreferences(context)
        pref.edit().putString(Constant.PREFS_COUNTRY_KEY, code).apply()

        context!!.supportFragmentManager.popBackStack()
    }

}
