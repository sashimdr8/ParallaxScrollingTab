package com.dms.data.model

/**
 * Created by brain on 12/5/17.
 */

class BaseResponse<T> {
    var status=""
    var totalResults: Int = 0
    var articles: T? = null

}
