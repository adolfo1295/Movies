package com.example.moviedolphin.ui.principal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedolphin.api.responses.ApiResponse
import com.example.moviedolphin.api.responses.PopularMovieResponse
import com.example.moviedolphin.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MediatorLiveData<PopularMovieResponse>()
    private val compositeDispossable = CompositeDisposable()

    fun getMovies() {
        compositeDispossable.add(repository.getMovies()!!
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it.isSuccessful) {
                    Log.d("Retrofit", "Hola: $it")
                    _movies.value = it.body()
                } else {
                    Log.e("Retrofit","Error: +${(it.errorBody() as ResponseBody).string()}")
                }
            }
        )
    }

    fun getMoviesLive() = _movies
    fun getPopular() = repository.getPopularMovies()

    override fun onCleared() {
        super.onCleared()
        compositeDispossable.clear()
    }

}