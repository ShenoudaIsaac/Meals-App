package com.shnsh.domain.repo

import com.shnsh.domain.entity.CategoryResponse

interface MealsRepo {
    fun getMealsFromRemote():CategoryResponse
}