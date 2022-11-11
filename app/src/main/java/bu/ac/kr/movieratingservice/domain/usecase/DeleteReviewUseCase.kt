package bu.ac.kr.movieratingservice.domain.usecase

import bu.ac.kr.movieratingservice.data.repository.ReviewRepository

class DeleteReviewUseCase(
    private val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke(review : Review) =
        reviewRepository.removeReview(review)
}