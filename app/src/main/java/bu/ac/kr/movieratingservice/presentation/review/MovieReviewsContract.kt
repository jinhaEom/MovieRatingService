package bu.ac.kr.movieratingservice.presentation.review

import bu.ac.kr.movieratingservice.BasePresenter
import bu.ac.kr.movieratingservice.BaseView
import bu.ac.kr.movieratingservice.domain.model.Movie
import bu.ac.kr.movieratingservice.domain.model.Review


interface MovieReviewsContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message : String)

        fun showMovieInformation(movie: Movie)

        fun showReviews(reviews: List<Review>)

    }
    interface Presenter : BasePresenter {
        val movie : Movie
    }
}