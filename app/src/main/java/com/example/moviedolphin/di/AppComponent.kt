package com.example.moviedolphin.di

import android.app.Application
import com.example.moviedolphin.di.module.AppModule
import com.example.moviedolphin.di.module.MainViewModelModule
import com.example.moviedolphin.di.module.MovieRepositoryModule
import com.example.moviedolphin.di.module.NetworkModule
import com.example.moviedolphin.ui.principal.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        MovieRepositoryModule::class,
        MainViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)

}