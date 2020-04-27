package com.example.johnny.newsapp.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.johnny.newsapp.Constant
import com.example.johnny.newsapp.R
import com.example.johnny.newsapp.adapters.NewsListAdapter
import com.example.johnny.newsapp.models.NewsViewModel
import com.example.johnny.newsapp.pojos.News
import com.squareup.picasso.Picasso

class SourceNewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerViewManager: RecyclerView.LayoutManager

    private var model = NewsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_source_news, container, false)

        setActionBar(view)

        val code =  arguments!!.getString(Constant.SOURCE_CODE_KEY)
        val url = arguments!!.getString(Constant.SOURCE_URL_KEY)

        setRecyclerView(view, code)

        val imageView = view.findViewById<ImageView>(R.id.sourceNewsImageView)
        Picasso.get().load(url).placeholder(R.drawable.progress_animation).into(imageView)

        observe(code)

        return view
    }


    private fun setActionBar(view: View){
        val toolbar = view.findViewById<Toolbar>(R.id.sourceNewsToolbar)
        setHasOptionsMenu(true)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar.apply {
            this!!.setDisplayHomeAsUpEnabled(true)
            this!!.setDisplayShowHomeEnabled(true)
        }
    }

    private fun setRecyclerView(view: View, code: String){
        recyclerViewManager = LinearLayoutManager(activity)
        recyclerViewAdapter = NewsListAdapter(model.getDataBySource(code)!!.value, activity!!)
        recyclerView = view.findViewById<RecyclerView>(R.id.sourceNewsRecyclerView).apply {
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
            layoutManager  = recyclerViewManager
        }
    }

    private fun observe(code: String){

        this.model = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        this.model.getDataBySource(code).observe(this, Observer { list: List<News>? ->
            recyclerViewAdapter = NewsListAdapter(list, activity!!)
            recyclerViewAdapter.notifyDataSetChanged()
            recyclerView.apply {
                adapter = recyclerViewAdapter
            }

        });
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
            return SourceNewsFragment()
        }
    }

}