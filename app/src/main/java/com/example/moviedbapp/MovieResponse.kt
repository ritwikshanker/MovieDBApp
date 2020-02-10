package com.example.moviedbapp

class MoviesResponse {
    private var page:Int
        get() {
            return this.page
        }
        set(page) {
            this.page = page
        }
    var results:List<Movie>
        get() {
            return results
        }
        set(results) {
            this.results = results
        }
    var totalResults:Int
        get() {
            return totalResults
        }
        set(totalResults) {
            this.totalResults = totalResults
        }
    var totalPages:Int
        get() {
            return totalPages
        }
        set(totalPages) {
            this.totalPages = totalPages
        }
}