package com.example.moviedbapp

import com.example.moviedbapp.adapter.MoviesAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbapp.model.MoviesResponse
import com.example.moviedbapp.rest.ApiClient
import com.example.moviedbapp.rest.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        recyclerView.adapter = MoviesAdapter(
//            movies, R.layout.list_item_movie,
//            applicationContext
//        )
        if (API_KEY.isEmpty()) {
            Toast.makeText(
                applicationContext,
                "Please obtain your API KEY from themoviedb.org",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        val recyclerView = findViewById<RecyclerView>(R.id.movies_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val apiService = ApiClient.client?.create(ApiInterface::class.java)
        val call = apiService?.getTopRatedMovies(API_KEY,2)
        call?.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                val movies = response.body()?.movies;
                if (movies != null) {
                    recyclerView.adapter = MoviesAdapter(
                        movies, R.layout.list_item_movie,
                        applicationContext
                    )
                    Log.d(TAG, "Number of movies received: " + movies.size)
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                // Log error here since request failed
                Log.e(TAG, t.toString())
            }
        })
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val API_KEY = "762468f515d6235dff546e41954f9c3c"
    }
}