package bu.ac.kr.movieratingservice.data.api

import bu.ac.kr.movieratingservice.domain.model.Review
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await


class ReviewFirestoreApi(
    private val firestore: FirebaseFirestore // 핫한 영화  firebaseStore 구성
) : ReviewApi {

    override suspend fun getLatestReview(movieId: String): Review? =
        firestore.collection("reviews")
            .whereEqualTo("movieId", movieId)
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .limit(1)
            .get()
            .await()
            .map { it.toObject<Review>() }
            .firstOrNull()

    override suspend fun getAllReviews(movieId: String): List<Review> =
        firestore.collection("reviews")
            .whereEqualTo("movieId", movieId)
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .await()
            .map{ it.toObject<Review>() }
    override suspend fun getAllUserReviews(userId : String): List<Review> =
        firestore.collection("reviews")
            .whereEqualTo("userId",userId)
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .await()
            .map { it.toObject<Review>()}

}
