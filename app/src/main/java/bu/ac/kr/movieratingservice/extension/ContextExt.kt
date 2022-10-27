package bu.ac.kr.movieratingservice.extension

import android.content.Context
import androidx.annotation.Px


@Px
fun Context.dip(dipValue: Float) = (dipValue * resources.displayMetrics.density).toInt()
