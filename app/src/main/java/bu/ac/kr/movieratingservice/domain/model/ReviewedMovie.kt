package bu.ac.kr.movieratingservice.domain.model

data class ReviewedMovie(
    val movie : Movie,
    val myReview : Review
)