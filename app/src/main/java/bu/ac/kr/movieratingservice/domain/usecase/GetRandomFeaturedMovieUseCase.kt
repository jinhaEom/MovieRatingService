package bu.ac.kr.movieratingservice.domain.usecase

/*import bu.ac.kr.movieratingservice.data.repository.MovieRepository
import bu.ac.kr.movieratingservice.data.repository.ReviewRepository*/
import bu.ac.kr.movieratingservice.domain.model.FeaturedMovie
/*

class GetRandomFeaturedMovieUseCase(
    private val movieRepository: MovieRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(): FeaturedMovie? {
        val featuredMovies = movieRepository.getAllMovies()
            .filter { it.id.isNullOrBlank().not() }
            .filter { it.isFeatured == true }

        if (featuredMovies.isNullOrEmpty()) {
            return null
        }

        return featuredMovies.random()
            .let { movie ->
                val latestReview = reviewRepository.getLatestReview(movie.id!!)
                FeaturedMovie(movie, latestReview)
            }
    }
}*/
