package com.example.moviedbapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("762468f515d6235dff546e41954f9c3c") apiKey: String): Call<Movie>

    @GET("movie/{id}")
    fun getMovieDetails(@Path("505") id: Int, @Query("762468f515d6235dff546e41954f9c3c") apiKey: String): Call<Movie>
}