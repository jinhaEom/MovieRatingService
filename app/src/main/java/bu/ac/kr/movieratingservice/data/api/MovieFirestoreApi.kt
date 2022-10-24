package bu.ac.kr.movieratingservice.data.api

import bu.ac.kr.movieratingservice.domain.model.Movie
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await

class MovieFirestoreApi(
    private val firestore : FirebaseFirestore
): MovieApi {

    override suspend fun getAllMovies(): List<Movie> =
        firestore.collection("movies")
            .get()
            .await()
            .map{ it.toObject<Movie>()}
}
