package bu.ac.kr.movieratingservice.domain.usecase

import bu.ac.kr.movieratingservice.data.repository.MovieRepository
import bu.ac.kr.movieratingservice.data.repository.ReviewRepository
import bu.ac.kr.movieratingservice.data.repository.UserRepository
import bu.ac.kr.movieratingservice.domain.model.ReviewedMovie
import com.google.firebase.firestore.auth.User

class GetMyReviewedMoviesUseCase(
    private val userRepository : UserRepository,
    private val reviewRepository : ReviewRepository,
    private val movieRepository : MovieRepository
) {
    suspend operator fun invoke(): List<ReviewedMovie>{
        val user =userRepository.getUser()

        if(user ==null){
            userRepository.saveUser(User())
            return emptyList()
        }
        val reviews = reviewRepository.getAllUserReviews(user.id!!)
            .filter{ it.movieId.isNullOrBlank().not()}

        if(reviews.isNullOrEmpty()){
            return emptyList()
        }
        return movieRepository
            .getMovies(review.map {it.movieId!!})
            .mapNotNull { movie ->
                val relatedReview =reviews.find{ it.movieId == movie.id}
                relatedReview?.let { ReviewedMovie(movie,it)}
            }
    }
}