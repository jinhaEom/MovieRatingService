package bu.ac.kr.movieratingservice.data.api

import bu.ac.kr.movieratingservice.domain.model.User

interface UserApi {

    suspend fun saveUser(user: User): User
}