package bu.ac.kr.movieratingservice.presentation.review



interface MovieReviewsContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message : String)

        fun showMovieInformation(movie: Movie)

        fun showReviews(reviews: List<Review>)

    }
    interface Presenter : BasePresenter{
        val movie : Movie
    }
}