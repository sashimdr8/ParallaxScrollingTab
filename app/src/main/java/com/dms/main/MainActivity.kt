package com.dms.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.dms.PagerAdapter
import com.dms.databinding.ActivityMainBinding
import com.dms.R
import com.github.florent37.hollyviewpager.HollyViewPager
import com.github.florent37.hollyviewpager.HollyViewPagerBus
import com.github.florent37.hollyviewpager.HollyViewPagerConfigurator
import com.dms.R.id.hollyViewPager



/**
 * Created by brain on 12/5/17.
 */
class MainActivity : BaseActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main)
        val titles = ArrayList<String>()
        titles.add("Title 1")
        titles.add("Title 2")
        binding.hollyViewPager.configurator = HollyViewPagerConfigurator { page->
            ((page+4)%10)/10f
        }
        binding.hollyViewPager.setAdapter(PagerAdapter(supportFragmentManager, titles))



    }


}