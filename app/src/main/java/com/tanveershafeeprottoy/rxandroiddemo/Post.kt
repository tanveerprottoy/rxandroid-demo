package com.tanveershafeeprottoy.rxandroiddemo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author Tanveer Shafee Prottoy
 */
@JsonClass(generateAdapter = true)
data class Post(
    @Json(name = "userId")
    var userId: Int = 0,
    @Json(name = "id")
    var id: Int = 0,
    @Json(name = "title")
    var title: String? = null,
    @Json(name = "body")
    var body: String? = null
)