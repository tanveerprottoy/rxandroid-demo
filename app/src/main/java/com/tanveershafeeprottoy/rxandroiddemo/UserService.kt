package com.tanveershafeeprottoy.rxandroiddemo

import io.reactivex.Single
import retrofit2.http.GET

interface UserService {

    @GET(Constants.USERS_URL)
    fun getAll(): Single<List<User>>

    @GET(Constants.POSTS_URL)
    fun getPosts(): Single<List<Post>>
}