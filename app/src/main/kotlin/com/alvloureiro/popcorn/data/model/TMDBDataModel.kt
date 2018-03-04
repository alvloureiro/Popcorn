package com.alvloureiro.popcorn.data.model

import com.alvloureiro.popcorn.api.MoviesDataBase
import com.alvloureiro.popcorn.data.valueobjects.Genre
import com.alvloureiro.popcorn.data.valueobjects.Movie
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TMDBDataModel @Inject constructor(private val moviesDataBase: MoviesDataBase){
    fun upComingMovies(page: Int = 1): Observable<List<Movie>>? {
        return moviesDataBase.upcomingMovies(page)
                ?.filter { result -> (result.results?.isNotEmpty() as Boolean)}
                ?.map { result -> (result.results) }
    }

    fun genres(): Observable<List<Genre>>? {
        return moviesDataBase.genres()
                ?.filter { result ->  (result.genres?.isNotEmpty() as Boolean)}
                ?.map { result -> (result.genres) }
    }

    fun searchMovie(movieTitle: String, page: Int): Observable<List<Movie>>? {
        return moviesDataBase.searchMovie(movieTitle, page)
                ?.filter { result -> (result.results?.isNotEmpty() as Boolean)}
                ?.map { result -> result.results }
    }
}
