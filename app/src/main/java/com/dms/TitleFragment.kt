package com.dms

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.florent37.hollyviewpager.HollyViewPagerBus
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.dms.data.model.Article
import com.dms.databinding.FragmentTitleBinding
import com.dms.main.MenuAdapter
import io.reactivex.functions.Consumer


class TitleFragment : Fragment() {
    private lateinit var title: String
    private lateinit var binding: FragmentTitleBinding
    private lateinit var component: AppComponent

    companion object {
        fun newInstance(title: String): TitleFragment {
            var frag = TitleFragment()
            frag.title = title
            return frag
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        component = App.component(activity as FragmentActivity)
        getArticles()
        return binding.root
    }

    private fun getArticles() {
        component.data().getArticles()
                .subscribe({ articles ->
                    showArticles(articles) }
                        , { t ->
                    Log.e("articleerror", t.message)
                })
    }


    private fun showArticles(articles: List<Article>) {
        binding.rv.adapter = MenuAdapter(articles, activity)
    }
}
