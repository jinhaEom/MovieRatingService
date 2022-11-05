package bu.ac.kr.movieratingservice.data.api

import bu.ac.kr.movieratingservice.domain.model.Review

interface ReviewApi {

    suspend fun getLatestReview(movieId: String): Review?

    suspend fun getAllReviews(movieId : String) : List<Review>

    suspend fun getAllUserReviews(userId: String): List<Review>

}