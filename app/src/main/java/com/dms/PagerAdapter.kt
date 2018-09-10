package com.dms

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagerAdapter(fragmentManager: FragmentManager, private val titles: ArrayList<String>) :
    FragmentStatePagerAdapter(fragmentManager) {

  // 2   
  override fun getItem(position: Int): Fragment {
    return TitleFragment.newInstance(titles[position])
  }

  // 3  
  override fun getCount(): Int {
    return titles.size
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return "TITLE $position"
  }
}