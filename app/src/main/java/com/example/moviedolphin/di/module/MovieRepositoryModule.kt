package com.example.moviedolphin.di.module

import com.example.moviedolphin.api.ApiService
import com.example.moviedolphin.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieRepositoryModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(apiService: ApiService) = MovieRepository(apiService)

}