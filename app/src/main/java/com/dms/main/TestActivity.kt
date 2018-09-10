package com.dms.main

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.dms.PagerAdapter
import com.dms.R
import com.dms.databinding.ActivityTestBinding
import android.widget.LinearLayout
import android.support.v4.content.ContextCompat
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.support.v7.graphics.Palette


class TestActivity : AppCompatActivity() {

    lateinit var binding: ActivityTestBinding
    lateinit var context :Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        context = this
        val titles = ArrayList<String>()
        titles.add("Title 1")
        titles.add("Title 2")
        titles.add("Title 3")
        titles.add("Title 4")

//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Title 1"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Title 2"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Title 3"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Title 4"))
        binding.htabViewpager.adapter = PagerAdapter(supportFragmentManager, titles)

        binding.htabTabs.setupWithViewPager(binding.htabViewpager)

        initialise()


    }

    private fun initialise() {
        try {
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.photo)
            Palette.from(bitmap).generate { palette ->
                val vibrantColor = palette.getVibrantColor(ContextCompat.getColor(context, R.color.colorPrimary))
                val vibrantDarkColor = palette.getDarkVibrantColor(ContextCompat.getColor(context,R.color.colorPrimaryDark))
                binding.htabCollapseToolbar.setContentScrimColor(vibrantColor)
                binding.htabCollapseToolbar.setStatusBarScrimColor(vibrantDarkColor)
            }

        } catch (e: Exception) {
            // if Bitmap fetch fails, fallback to primary colors
//            Log.e(FragmentActivity.TAG, "onCreate: failed to create bitmap from background", e.fillInStackTrace())
            binding.htabCollapseToolbar.setContentScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimary)
            )
            binding.htabCollapseToolbar.setStatusBarScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimaryDark)
            )
        }

    }

}



