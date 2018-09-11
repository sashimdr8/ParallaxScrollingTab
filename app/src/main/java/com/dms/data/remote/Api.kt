package com.dms.data.remote

import com.dms.data.model.Article
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by brain on 12/5/17.
 */

interface Api {

    @GET("top-headlines?sources=google-news&apiKey=d2d54cdc4dc3460cb28d94bdbb05d657")
    fun getArticles(): Single<List<Article>>
}