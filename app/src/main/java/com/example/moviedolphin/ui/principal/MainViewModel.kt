package com.example.moviedolphin.ui.principal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviedolphin.api.responses.PopularMovieResponse
import com.example.moviedolphin.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import javax.inject.Inject

class MainViewModel @Inject constructor(repository: MovieRepository) : ViewModel() {

    val data: LiveData<Response<PopularMovieResponse>> =
        liveData(Dispatchers.IO) {
            val retrievedData = repository.getPopularMovies()
            emit(retrievedData)
        }

}