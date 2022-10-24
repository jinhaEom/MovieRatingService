package bu.ac.kr.movieratingservice.presentation.home

import bu.ac.kr.movieratingservice.BasePresenter
import bu.ac.kr.movieratingservice.BaseView
import bu.ac.kr.movieratingservice.domain.model.FeaturedMovie
import bu.ac.kr.movieratingservice.domain.model.Movie

interface HomeContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovies(
            featuredMovie: FeaturedMovie?,
            movies: List<Movie>
        )
    }

    interface Presenter : BasePresenter
}