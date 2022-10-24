package bu.ac.kr.movieratingservice.extension

import java.text.DecimalFormat

fun Float.toDecimalFormatString(format: String): String = DecimalFormat(format).format(this)
