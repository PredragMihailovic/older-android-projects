package com.example.johnny.newsapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.*
import com.example.johnny.newsapp.R
import com.example.johnny.newsapp.adapters.CountryListAdapter
import com.example.johnny.newsapp.models.CountryDataModel


class CountryListFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerViewManager: RecyclerView.LayoutManager

    var model = CountryDataModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_country_list, container, false)

        setActionBar(view)
        setRecyclerView(view)

        return view
    }

    private fun setActionBar(view: View){
        val toolbar = view.findViewById<Toolbar>(R.id.countryToolbar)
        setHasOptionsMenu(true)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar.apply {
            this!!.setDisplayHomeAsUpEnabled(true)
            this!!.setDisplayShowHomeEnabled(true)
        }
    }

    private fun setRecyclerView(view: View){
        recyclerViewManager = LinearLayoutManager(activity)
        recyclerViewAdapter = CountryListAdapter(model.countriesData, activity!!)
        recyclerView = view.findViewById<RecyclerView>(R.id.countryListRecyclerView).apply {
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
            layoutManager  = recyclerViewManager
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if(id == android.R.id.home){
            activity!!.supportFragmentManager.beginTransaction().remove(this).commit()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance(): Fragment {
            return CountryListFragment()
        }
    }

}
