package com.tanveershafeeprottoy.rxandroiddemo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author Tanveer Shafee Prottoy
 */
@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id")
    var id: Int = 0,
    @Json(name = "name")
    var name: String? = null,
    @Json(name = "username")
    var username: String? = null,
    @Json(name = "email")
    var email: String? = null
)