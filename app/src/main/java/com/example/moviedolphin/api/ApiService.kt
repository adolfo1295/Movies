package com.example.moviedolphin.api

import com.example.moviedolphin.api.responses.ErrorResponse
import com.example.moviedolphin.api.responses.PopularMovieResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@QueryMap parameters: HashMap<String, String>): Response<PopularMovieResponse>
}