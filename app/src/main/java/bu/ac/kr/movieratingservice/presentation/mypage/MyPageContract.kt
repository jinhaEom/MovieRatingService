package bu.ac.kr.movieratingservice.presentation.mypage

import bu.ac.kr.movieratingservice.BasePresenter
import bu.ac.kr.movieratingservice.BaseView
import bu.ac.kr.movieratingservice.domain.model.ReviewedMovie
import bu.ac.kr.movieratingservice.presentation.review.MovieReviewsContract

class MyPageContract {

    interface View : BaseView<MovieReviewsContract.Presenter> {
        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showNoDataDescription(message : String)

        fun showErrorDescription(message : String)

        fun showReviewedMovies(reviewedMovies : List<ReviewedMovie>)


    }
    interface Presenter : BasePresenter
}