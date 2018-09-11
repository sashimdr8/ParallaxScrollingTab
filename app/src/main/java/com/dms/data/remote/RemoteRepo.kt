package com.dms.data.remote

import com.dms.data.model.Article
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by brain on 12/5/17.
 */

@SuppressWarnings("unchecked")
class RemoteRepo @Inject constructor(private val api: Api, private val gson: Gson) {

    fun getArticles(): Single<List<Article>> {
        return api.getArticles()
    }
}