package bu.ac.kr.movieratingservice.presentation.mypage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bu.ac.kr.movieratingservice.databinding.ItemReviewedMovieBinding
import bu.ac.kr.movieratingservice.domain.model.Movie
import bu.ac.kr.movieratingservice.domain.model.ReviewedMovie
import bu.ac.kr.movieratingservice.extension.toDecimalFormatString
import com.bumptech.glide.Glide

class MyPageAdapter : RecyclerView.Adapter<MyPageAdapter.ViewHolder>() {

    var reviewedMovies : List<ReviewedMovie> = emptyList()
    var onMovieClickListener : ((Movie)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageAdapter.ViewHolder =
        ViewHolder(
            ItemReviewedMovieBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun getItemCount() : Int = reviewedMovies.size

        override fun onBindViewHolder(holder: MyPageAdapter.ViewHolder, position: Int) : Unit =
            holder.bind(reviewedMovies[position])
        inner class ViewHolder(private val binding : ItemReviewedMovieBinding):
            RecyclerView.ViewHolder(binding.root){

                init {
                    binding.root.setOnClickListener {
                        onMovieClickListener?.invoke(reviewedMovies[adapterPosition].movie)
                    }
                }

            @SuppressLint("SetTextI18n")
            fun bind(item: ReviewedMovie) {
                Glide.with(binding.root)
                    .load(item.movie.posterUrl)
                    .into(binding.posterImageView)

                binding.myScoreTextView.text = item.myReview.score?.toDecimalFormatString("0.0")
            }
    }
}