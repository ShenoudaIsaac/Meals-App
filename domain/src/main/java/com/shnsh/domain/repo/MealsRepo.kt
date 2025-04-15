package com.shnsh.domain.repo

import com.shnsh.domain.entity.CategoryResponse

interface MealsRepo {
    suspend fun getMealsFromRemote():CategoryResponse
}