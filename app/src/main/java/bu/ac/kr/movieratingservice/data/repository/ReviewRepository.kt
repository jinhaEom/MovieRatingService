package bu.ac.kr.movieratingservice.data.repository

import bu.ac.kr.movieratingservice.domain.model.Review


interface ReviewRepository {

    suspend fun getLatestReview(movieId: String): Review?
}
