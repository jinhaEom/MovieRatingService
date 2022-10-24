package bu.ac.kr.movieratingservice.data.repository

import bu.ac.kr.movieratingservice.domain.model.Movie


interface MovieRepository {
    suspend fun getAllMovies() : List<Movie>
}
