package com.example.moviedbapp.rest

import com.example.moviedbapp.model.Movie
import com.example.moviedbapp.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("movie/popular")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "762468f515d6235dff546e41954f9c3c", @Query(
            "page"
        ) page: Int
    ): Call<MoviesResponse>

    @GET("movie/{id}")
    fun getMovieDetails(@Path("505") id: Int, @Query("762468f515d6235dff546e41954f9c3c") apiKey: String): Call<Movie>
}