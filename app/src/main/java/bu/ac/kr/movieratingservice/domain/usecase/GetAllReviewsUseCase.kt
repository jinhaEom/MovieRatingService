package bu.ac.kr.movieratingservice.domain.usecase

import bu.ac.kr.movieratingservice.data.repository.ReviewRepository
import bu.ac.kr.movieratingservice.domain.model.Review

class GetAllReviewsUseCase(private val reviewRepository : ReviewRepository) {

    suspend operator fun invoke(movieId : String) : List<Review> =
        reviewRepository.getAllReviews(movieId)
}