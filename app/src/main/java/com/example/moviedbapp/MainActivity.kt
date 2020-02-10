package com.example.moviedbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (API_KEY.isEmpty()) {
            Toast.makeText(
                applicationContext,
                "Please obtain your API KEY from themoviedb.org",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        val apiService = ApiClient.client?.create(ApiInterface::class.java)
        val call = apiService?.getTopRatedMovies(API_KEY)
        call?.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val movies = response.body()?.original_title;
                if (movies != null) {
                    Log.d(TAG, "Number of movies received: " + movies.length)
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
            }
        })
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private val API_KEY = "762468f515d6235dff546e41954f9c3c"
    }
}