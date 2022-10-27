package bu.ac.kr.movieratingservice.data.api

import bu.ac.kr.movieratingservice.domain.model.Movie

interface MovieApi {

    suspend fun getAllMovies(): List<Movie>

    suspend fun getMovies(movieIds: List<String>): List<Movie>
}