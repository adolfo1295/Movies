package com.example.moviedolphin.repository

import com.example.moviedolphin.api.ApiService
import com.example.moviedolphin.api.responses.ErrorResponse
import com.example.moviedolphin.api.responses.PopularMovieResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.Response


class MovieRepository(private var apiService: ApiService) {
    suspend fun getPopularMovies(): Response<PopularMovieResponse> {
        val parameters: HashMap<String, String> = HashMap()
        parameters["api_key"] = "45bcb1d4412a817db500e7ca29965e48"
        parameters["language"] = "es-MX"
        parameters["page"] = "1"
        return apiService.getPopularMovies(parameters)
    }
}

