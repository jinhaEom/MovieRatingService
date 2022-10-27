package bu.ac.kr.movieratingservice.domain.model

data class FeaturedMovie(
    val movie: Movie,
    val latestReview: Review?
)