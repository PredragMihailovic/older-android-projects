package com.example.johnny.newsapp

import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import com.example.johnny.newsapp.fragments.CountryListFragment
import com.example.johnny.newsapp.fragments.CountryNewsFragment
import com.example.johnny.newsapp.fragments.SourcesListFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fab)

        floatingActionButton.setOnClickListener(View.OnClickListener {
            openCountryListFragment()
        })

    }

    private fun openCountryListFragment() {

        supportFragmentManager.beginTransaction().replace(android.R.id.content, CountryListFragment.newInstance())
                .addToBackStack(null).commit()

    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    return CountryNewsFragment.newInstance() }
                1 -> {
                    return SourcesListFragment.newInstance()
                }
                else -> return CountryNewsFragment.newInstance()
            }
        }

        override fun getCount(): Int {
            return 2
        }
    }

}
