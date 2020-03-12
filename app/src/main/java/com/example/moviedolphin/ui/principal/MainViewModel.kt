package com.example.moviedolphin.ui.principal

import androidx.lifecycle.ViewModel
import com.example.moviedolphin.repository.MovieRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    fun getPopular() = repository.getPopularMovies()

}