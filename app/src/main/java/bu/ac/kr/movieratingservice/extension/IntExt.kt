package bu.ac.kr.movieratingservice.extension

fun Int.toAbbreviatedString(): String = when (this) {
    in 0..1_000 -> {
        this.toString()
    }
    in 1_000..1_000_000 -> {
        "${(this / 1_000f).toDecimalFormatString("#.#")}K"  //#.# 은 정수일경우 소숫점 없애줌
    }
    else -> {
        "${(this / 1_000_000f).toDecimalFormatString("#.#")}M"
    }
}