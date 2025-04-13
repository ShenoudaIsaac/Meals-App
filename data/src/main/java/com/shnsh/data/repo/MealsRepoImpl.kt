package com.shnsh.data.repo

import com.shnsh.data.remote.ApiService
import com.shnsh.domain.entity.CategoryResponse
import com.shnsh.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService: ApiService):MealsRepo {
    override fun getMealsFromRemote(): CategoryResponse {
        return apiService.getMeals()
    }

}