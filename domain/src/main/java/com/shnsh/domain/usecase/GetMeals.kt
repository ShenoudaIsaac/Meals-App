package com.shnsh.domain.usecase

import com.shnsh.domain.repo.MealsRepo

class GetMeals(private val mealsRepo: MealsRepo) {
    suspend operator fun invoke()=mealsRepo.getMealsFromRemote()
}