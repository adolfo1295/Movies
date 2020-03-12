package com.example.moviedolphin.api

import androidx.lifecycle.LiveData
import com.example.moviedolphin.api.responses.ApiResponse
import com.example.moviedolphin.api.responses.PopularMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(@QueryMap parameters: HashMap<String, String>): LiveData<ApiResponse<PopularMovieResponse>>
}