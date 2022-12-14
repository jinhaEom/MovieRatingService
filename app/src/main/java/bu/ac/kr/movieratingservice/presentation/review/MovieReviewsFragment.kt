package bu.ac.kr.movieratingservice.presentation.review

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bu.ac.kr.movieratingservice.databinding.FragmentMovieReviewsBinding
import bu.ac.kr.movieratingservice.domain.model.Movie
import bu.ac.kr.movieratingservice.domain.model.Review
import org.koin.android.scope.ScopeFragment
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject


class MovieReviewsFragment: ScopeFragment() ,MovieReviewsContract.View {

    override val presenter : MovieReviewsContract.Presenter by inject { parametersOf(arguments.movie)}

    private val arguments: MovieReviewsFragmentArgs by navArgs()
    private var binding : FragmentMovieReviewsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ): View = FragmentMovieReviewsBinding.inflate(inflater , container, false)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.onViewCreated()
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
    override fun showLoadingIndicator(){
        binding?.progressBar?.isVisible = true
    }
    override fun hideLoadingIndicator() {
        binding?.progressBar?.isVisible = false
    }
    override fun showErrorDescription(message: String){
        binding?.recyclerView?.isVisible = false
        binding?.errorDescriptionTextView?.isVisible = true
        binding?.errorDescriptionTextView?.text = message
    }
    override fun showMovieInformation(movie: Movie){
        binding?.recyclerView?.adapter = MovieReviewsAdapter(movie)
    }
    override fun showReviews(reviews : List<Review>){
        binding?.recyclerView?.isVisible = true
        binding?.errorDescriptionTextView?.isVisible = false
        (binding?.recyclerView?.adapter as? MovieReviewsAdapter)?.apply{
            this.reviews = reviews
            notifyDataSetChanged()
        }
    }
    private fun initViews(){
        binding?.recyclerView?.apply{
            layoutManager = LinearLayoutManager(
                this.context,
                RecyclerView.VERTICAL,
                false
            )
        }
    }
}
