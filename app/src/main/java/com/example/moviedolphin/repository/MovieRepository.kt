package com.example.moviedolphin.repository

import androidx.lifecycle.LiveData
import com.example.moviedolphin.api.ApiService
import com.example.moviedolphin.api.responses.ApiResponse
import com.example.moviedolphin.api.responses.PopularMovieResponse
import retrofit2.Response


class MovieRepository(private var apiService: ApiService) {
    fun getPopularMovies(): LiveData<ApiResponse<PopularMovieResponse>> {
        val parameters: HashMap<String, String> = HashMap()
        parameters["api_key"] = ""
        parameters["language"] = "es-MX"
        parameters["page"] = "1"
        return apiService.getPopularMovies(parameters)
    }
}

