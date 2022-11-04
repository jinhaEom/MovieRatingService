package bu.ac.kr.movieratingservice.preference


interface PreferenceManager {

    fun getString(key: String): String?

    fun putString(key: String, value: String)
}