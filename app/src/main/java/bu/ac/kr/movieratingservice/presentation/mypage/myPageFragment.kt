package bu.ac.kr.movieratingservice.presentation.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bu.ac.kr.movieratingservice.databinding.FragmentMyPageBinding
import bu.ac.kr.movieratingservice.domain.model.ReviewedMovie
import bu.ac.kr.movieratingservice.extension.dip
import bu.ac.kr.movieratingservice.extension.toGone
import bu.ac.kr.movieratingservice.extension.toVisible
import bu.ac.kr.movieratingservice.presentation.home.GridSpacingItemDecoration
import org.koin.android.scope.ScopeFragment


class MyPageFragment : ScopeFragment(), MyPageContract.View {

    override val presenter: MyPageContract.Presenter by inject()

    private var binding: FragmentMyPageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMyPageBinding.inflate(inflater, container, false)
        .also { binding = it}
        .root

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoadingIndicator() {
        binding?.progressBar?.toVisible()
    }

    override fun hideLoadingIndicator() {
        binding?.progressBar?.toGone()
    }

    override fun showNoDataDescription(message: String) {
        binding?.recyclerView?.toGone()
        binding?.descriptionTextView?.toVisible()
        binding?.descriptionTextView?.text = message
    }

    override fun showErrorDescription(message: String) {
        binding?.recyclerView?.toGone()
        binding?.descriptionTextView?.toVisible()
        binding?.descriptionTextView?.text = message
    }

    override fun showReviewedMovies(reviewedMovies: List<ReviewedMovie>) {
        (binding?.recyclerView?.adapter as? MyPageAdapter)?.apply{
            this.reviewedMovies = reviewedMovies
            notifyDataSetChanged()
        }
    }
    private fun initViews() {
        binding?.recyclerView?.apply{
            adapter = MyPageAdapter()
            layoutManager = GridLayoutManager(context,3, RecyclerView.VERTICAL, false)
            addItemDecoration(GridSpacingItemDecoration(3,dip(6f)))

        }
    }
    private fun bindView() {
        (binding?.recyclerView?.adapter as? MyPageAdapter)?.apply{
            onMovieClickListener = { movie ->
                val action = myPageFragmentDirections.toMovieReviewsAction(movie)
                findNavController().navigate(action)
            }
        }
    }
}