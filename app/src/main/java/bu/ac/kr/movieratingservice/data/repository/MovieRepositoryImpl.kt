package bu.ac.kr.movieratingservice.data.repository

import bu.ac.kr.movieratingservice.data.api.MovieApi
import bu.ac.kr.movieratingservice.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/*
class MovieRepositoryImpl(
    private val movieApi : MovieApi,
    private val dispatchers : CoroutineDispatcher
) : MovieRepository{
    override suspend fun getAllMovies(): List<Movie> = withContext(dispatchers) {
        movieApi.getAllMovies()
    }
}*/
