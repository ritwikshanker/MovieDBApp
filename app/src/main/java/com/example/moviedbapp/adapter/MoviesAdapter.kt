package com.example.moviedbapp.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbapp.R
import com.example.moviedbapp.R.id.item_movie_poster
import com.example.moviedbapp.R.id.movies_layout
import com.example.moviedbapp.model.Movie


class MoviesAdapter(movies: List<Movie>, rowLayout: Int, context: Context) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    private val movies: List<Movie> = movies
    private var rowLayout: Int = 0
    private val context: Context

    class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var moviesLayout: LinearLayout = v.findViewById(movies_layout) as LinearLayout
        internal var movieTitle: TextView = v.findViewById(R.id.title) as TextView
        internal var data: TextView = v.findViewById(R.id.subtitle) as TextView
        internal var movieDescription: TextView = v.findViewById(R.id.description) as TextView
        internal var rating: TextView = v.findViewById(R.id.rating) as TextView
        internal var poster : ImageView = v.findViewById(R.id.item_movie_poster) as ImageView
    }

    init {
        this.rowLayout = rowLayout
        this.context = context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].original_title
        holder.data.text = movies[position].release_date
        holder.movieDescription.text = movies[position].overview
        holder.rating.text = movies[position].vote_average.toString()
//        myHolder.imageUrl = current.itemImage;
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}