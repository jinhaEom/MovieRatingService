package bu.ac.kr.movieratingservice.presentation.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bu.ac.kr.movieratingservice.databinding.FragmentMovieReviewsBinding
import org.koin.android.scope.ScopeFragment
import org.koin.core.parameter.parametersOf


class MovieReviewsFragment: ScopeFragment(). MovieReviewsContract.View {

    override val presenter : MovieReviewsContract.Presenter by inject { parametersOf(arguments)}

    private val arguments: MovieReviewsFragmentArgs by navArgs()
    private var binding : FragmentMovieReviewsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ): View = FragmentMovieReviewsBinding.inflate(inflater , container, false)
        .also { binding = it }
        .root

    override fun onViewCreated(view : View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

    }
}