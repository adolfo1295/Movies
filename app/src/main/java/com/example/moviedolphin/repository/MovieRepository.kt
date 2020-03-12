package com.example.moviedolphin.repository

import androidx.lifecycle.LiveData
import com.example.moviedolphin.api.ApiService
import com.example.moviedolphin.api.responses.ApiResponse
import com.example.moviedolphin.api.responses.PopularMovieResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response


class MovieRepository(private var apiService: ApiService) {
    fun getPopularMovies(): LiveData<ApiResponse<PopularMovieResponse>> {
        val parameters: HashMap<String, String> = HashMap()
        parameters["api_key"] = ""
        parameters["language"] = "es-MX"
        parameters["page"] = "1"
        return apiService.getPopularMovies(parameters)
    }

    fun getMovies(): Flowable<Response<PopularMovieResponse>>? {
        val parameters: HashMap<String, String> = HashMap()
        parameters["api_key"] = "45bcb1d4412a817db500e7ca29965e48"
        parameters["language"] = "es-MX"
        parameters["page"] = "1"
        return apiService.getPopularMoviesSingle(parameters).toFlowable(BackpressureStrategy.LATEST)
    }


}

