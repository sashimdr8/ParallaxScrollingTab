package com.dms.data

import com.dms.data.local.LocalRepo
import com.dms.data.model.Article
import com.dms.data.remote.RemoteRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by brain on 12/5/17.
 */
class AppData @Inject
internal constructor(private val localRepo: LocalRepo,
                     private val remoteRepo: RemoteRepo) {


    fun getArticles(): Single<List<Article>> {
        return remoteRepo.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}