package bu.ac.kr.movieratingservice.presentation.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bu.ac.kr.movieratingservice.databinding.FragmentMyPageBinding
import bu.ac.kr.movieratingservice.domain.model.ReviewedMovie
import bu.ac.kr.movieratingservice.extension.toGone
import bu.ac.kr.movieratingservice.extension.toVisible
import org.koin.android.scope.ScopeFragment


class myPageFragment: ScopeFragment(), MyPageContract.View {

    override val presenter : MyPageContract.Presenter by inject()

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


}