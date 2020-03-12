package com.example.moviedolphin.api

import androidx.lifecycle.LiveData
import com.example.moviedolphin.api.responses.ApiResponse
import com.example.moviedolphin.api.responses.PopularMovieResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(@QueryMap parameters: HashMap<String, String>): LiveData<ApiResponse<PopularMovieResponse>>

    @GET("movie/popular")
    fun getPopularMoviesSingle(@QueryMap parameters: HashMap<String, String>): Observable<Response<PopularMovieResponse>>

}

