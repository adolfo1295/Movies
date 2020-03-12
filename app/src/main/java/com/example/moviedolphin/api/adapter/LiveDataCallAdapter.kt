package com.example.moviedolphin.api.adapter

import androidx.lifecycle.LiveData
import com.example.moviedolphin.api.responses.ApiResponse
import com.example.moviedolphin.api.responses.UNKNOWN_CODE
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

/**
 * Created by Adolfo Chavez on 3/11/2020.
 */
class LiveDataCallAdapter<R>(private val responseType: Type):
    CallAdapter<R, LiveData<ApiResponse<R>>> {
    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>() {
            private var isSuccess = false
            override fun onActive() {
                super.onActive()
                if (!isSuccess) enqueue()
            }
            override fun onInactive() {
                super.onInactive()
                dequeue()
            }
            private fun dequeue() {
                if (call.isExecuted) call.cancel()
            }
            private fun enqueue() {
                call.enqueue(object : Callback<R> {
                    override fun onFailure(call: Call<R>, t: Throwable) {
                        postValue(ApiResponse.create(UNKNOWN_CODE, t))
                    }
                    override fun onResponse(call: Call<R>, response: Response<R>) {
                        postValue(ApiResponse.create(response))
                        isSuccess = true
                    }
                })
            }
        }
    }
    override fun responseType(): Type = responseType
}