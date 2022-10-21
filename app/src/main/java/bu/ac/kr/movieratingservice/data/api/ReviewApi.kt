package bu.ac.kr.movieratingservice.data.api

import bu.ac.kr.movieratingservice.domain.model.Review

interface ReviewApi {

    suspend fun getLatestReview(movieId: String): Review?

}