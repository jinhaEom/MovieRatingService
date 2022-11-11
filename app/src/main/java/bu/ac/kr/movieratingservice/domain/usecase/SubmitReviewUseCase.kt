package bu.ac.kr.movieratingservice.domain.usecase

import bu.ac.kr.movieratingservice.data.repository.ReviewRepository
import bu.ac.kr.movieratingservice.data.repository.UserRepository

class SubmitReviewUseCase(
    private val userRepository : UserRepository,
    private val reviewRepository : ReviewRepository
){

    suspend operator fun invoke(
        movie : Movie,
        content : String,
        score : Float
    ): Review {
        var user = userRepository.getUser()

        if(user == null) {
            userRepository.saveUser(User())
            user = userRepository.getUser()
        }

        return reviewRepository.addReview(
            Review(
                userId = user!!.id,
                movieId = movie.id,
                content = content,
                score = score
            )
        )
    }
}