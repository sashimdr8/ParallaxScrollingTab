package com.dms

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Created by brain on 12/5/17.
 */
open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component(activity as FragmentActivity).inject(this)
    }

     fun consumeBackPress(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onTokenExpired() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}