package com.example.moviedolphin.ui.principal

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.moviedolphin.BaseApp
import com.example.moviedolphin.R
import com.example.moviedolphin.api.responses.ApiResponse
import com.example.moviedolphin.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as BaseApp).appComponent.inject(this)
        viewModel.getMovies()
        viewModel.getMoviesLive().observe(this) {
            Log.d("Retrofit","Hola: $it")
        }
    }
}
