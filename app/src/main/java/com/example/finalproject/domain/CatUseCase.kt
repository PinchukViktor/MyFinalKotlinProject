package com.example.finalproject.domain

import com.example.finalproject.data.CatRepository

object CatUseCase {

    private val remRepos = CatRepository

    suspend fun getFact(): String {

        return remRepos.getFactsOfCats()?.text.toString()


    }
}