package bu.ac.kr.movieratingservice.data.repository

import android.preference.PreferenceManager
import bu.ac.kr.movieratingservice.data.api.UserApi
import bu.ac.kr.movieratingservice.domain.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val userApi : UserApi,
    private val preferenceManager : PreferenceManager,

    private val dispatchers: CoroutineDispatcher ) : UserRepository{

    override suspend fun getUser(): User? = withContext(dispatchers) {
        preferenceManager.getString(KEY_USER_ID)?.LET { User(it)}

    }
    override suspend fun saveUser(user:User) = withContext(dispatchers){
        val newUser = userApi.saveUser(user)
        preferenceManager.putString(KEY_USER_ID, newUser.id!!)
    }
    companion object{
        private const val KEY_USER_ID = "KEY_USER_ID"
    }
}