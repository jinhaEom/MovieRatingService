package bu.ac.kr.movieratingservice.presentation.review

import android.annotation.SuppressLint
import android.view.ViewGroup
import bu.ac.kr.movieratingservice.databinding.ItemMovieInformationBinding
import java.lang.RuntimeException

class MovieReviewsAdapter(private val movie : Movie) : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var reviews : List<Review> = emptyList()

    override fun onCreateViewHolder(parent:ViewGroup, viewType : Int): RecyclerView.ViewHolder =
        when(viewType){
            ITEM_VIEW_TYPE_HEADER -> {
                MovieInformationViewHolder(
                    ItemMovieInformationBinding
                        .inflate(LayoutInflater.from(parent.context),parent,false)
                )
            }
            ITEM_VIEW_TYPE_ITEM ->{
                RecyclerViewHolder(parent)
            }
            else -> throw RuntimeException("알 수 없는 ViewType 입니다.")
        }
    override fun getItemCount() : Int = 1 + reviews.size

    override fun onBindViewHolder(holder : RecyclerView.ViewHolder , position: Int): Unit =
        when(holder) {
            is MovieInformationViewHolder -> {
                holder.bind(movie)
            }
            is ReviewViewHolder -> {
                holder.bind(reviews[position -1])
            }
            else -> throw RuntimeException("알 수 없는 ViewHolder 입니다.")
        }
    override fun getItemViewType(position : Int) : Int =
        when(position){
            0 -> ITEM_VIEW_TYPE_HEADER
            else 0 -> ITEM_VIEW_TYPE_ITEM
        }
    class MovieInformationViewHolder(private val binding : ItemMovieInformationBinding):
            RecyclerView.ViewHolder(binding.root){

        @SuppressLint("SetTextI18n")
        fun bind(item : Movie){
            Glide.with(binding.root)
                .load(item.posterUrl)
                .into(binding.posterImageView)

            item.let {
                binding.averageScoreTextView.text =
                    "평점 ${it.averageScore?.toDecimalFormatString}"
            }
        }

            }
    companion object {
        const val ITEM_VIEW_TYPE_HEADER = 0
        const val ITEM_VIEW_TYPE_ITEM = 1
        const val ITEM_VIEW_TYPE_REVIEW_FORM = 2
        const val ITEM_VIEW_TYPE_MY_REVIEW = 3
    }
}
