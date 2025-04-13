package com.shnsh.data.remote

import com.shnsh.domain.entity.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET ("categories.php")
    fun getMeals():CategoryResponse
}