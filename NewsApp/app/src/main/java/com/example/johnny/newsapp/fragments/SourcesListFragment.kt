package com.example.johnny.newsapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import com.example.johnny.newsapp.R
import com.example.johnny.newsapp.adapters.SourcesListAdapter
import com.example.johnny.newsapp.models.SourcesDataModel


class SourcesListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerViewManager: RecyclerView.LayoutManager


    var model = SourcesDataModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sources_list, container, false)

        setRecyclerView(view)

        return view
    }

    private fun setRecyclerView(view: View){
        recyclerViewManager = LinearLayoutManager(activity)
        recyclerViewAdapter = SourcesListAdapter(model.sourcesData, activity as AppCompatActivity)
        recyclerView = view.findViewById<RecyclerView>(R.id.sourcesListRecyclerView).apply {
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
            layoutManager  = recyclerViewManager
        }
    }

    companion object {
        fun newInstance(): Fragment {
            return SourcesListFragment()
        }
    }

}
