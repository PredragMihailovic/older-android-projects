package com.example.johnny.newsapp.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.johnny.newsapp.Constant
import com.example.johnny.newsapp.R
import com.example.johnny.newsapp.Utils
import com.example.johnny.newsapp.adapters.NewsListAdapter
import com.example.johnny.newsapp.models.NewsViewModel
import com.example.johnny.newsapp.pojos.News

class CountryNewsFragment : Fragment(), SharedPreferences.OnSharedPreferenceChangeListener {


    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerViewManager: RecyclerView.LayoutManager

    private var model = NewsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_country_news, container, false)

        val prefCountryCode = Utils.PreferenceHelper.getCountryCode(context!!)
        setRecyclerView(view, prefCountryCode)
        observe(prefCountryCode)

        return view
    }

    private fun observe(code: String){
        //this.model = ViewModelProviders.of(this).get(NewsViewModel::class.java)

        this.model.getDataByCountry(code).observe(this, Observer { list: List<News>? ->
            Log.v("MODEL", "Inside Observer!")
            recyclerViewAdapter = NewsListAdapter(list, activity!!)
            recyclerViewAdapter.notifyDataSetChanged()
            recyclerView.apply {
                adapter = recyclerViewAdapter
            }

        });

    }

    override fun onResume() {
        super.onResume()
        Utils.PreferenceHelper.getSharedPreferences(context!!).registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        Utils.PreferenceHelper.getSharedPreferences(context!!).registerOnSharedPreferenceChangeListener(this)
    }

    private fun setRecyclerView(view: View, code: String){
        recyclerViewManager = LinearLayoutManager(activity)
        recyclerViewAdapter = NewsListAdapter(model.getDataByCountry(code)!!.value, activity!!)
        recyclerView = view.findViewById<RecyclerView>(R.id.countryNewsRecyclerView).apply {
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
            layoutManager  = recyclerViewManager

        }
    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {
        Log.v("listEvent", "pref changed")
        observe(p0!!.getString(Constant.PREFS_COUNTRY_KEY, "rs"))
    }

    companion object {
        fun newInstance(): Fragment {
            return CountryNewsFragment()
        }
    }

}
