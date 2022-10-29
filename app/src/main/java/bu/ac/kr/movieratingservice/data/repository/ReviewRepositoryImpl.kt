package bu.ac.kr.movieratingservice.data.repository

import bu.ac.kr.movieratingservice.data.api.ReviewApi
import bu.ac.kr.movieratingservice.domain.model.Review
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


class ReviewRepositoryImpl(
    private val reviewApi : ReviewApi,
    private val dispatchers : CoroutineDispatcher
) : ReviewRepository{
    override suspend fun getLatestReview(movieId: String): Review? = withContext(dispatchers) {
        reviewApi.getLatestReview(movieId)
    }

    override suspend fun getAllReviews(movieId: String) : List<Review> = withContext(dispatchers) {

        reviewApi.getAllReviews(movieId)
    }
}
