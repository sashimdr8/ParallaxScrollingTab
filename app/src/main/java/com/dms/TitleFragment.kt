package com.dms

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.florent37.hollyviewpager.HollyViewPagerBus
import android.support.v7.widget.LinearLayoutManager
import com.dms.databinding.FragmentTitleBinding
import com.dms.main.MenuAdapter


class TitleFragment : Fragment() {
    private lateinit var title: String
    private lateinit var binding: FragmentTitleBinding

    companion object {
        fun newInstance(title: String): TitleFragment {
            var frag = TitleFragment()
            frag.title = title
            return frag
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
//        binding.rv.layoutManager = LinearLayoutManager(activity)
//        val titles = ArrayList<String>()
//        titles.add("Title 1")
//        titles.add("Title 2")
//        binding.rv.adapter = MenuAdapter(titles, activity)
//
//        HollyViewPagerBus.registerRecyclerView(activity, binding.rv)
        return binding.root
    }
}