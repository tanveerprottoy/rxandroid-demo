package com.tanveershafeeprottoy.rxandroiddemo

import io.reactivex.Single

object UserRepo {
    private val userService = NetUtils.retrofit.create(UserService::class.java)

    fun getAll(): Single<List<User>> {
        return userService.getAll()
    }

    fun getPosts(): Single<List<Post>> {
        return userService.getPosts()
    }
}