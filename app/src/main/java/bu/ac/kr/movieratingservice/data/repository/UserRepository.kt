package bu.ac.kr.movieratingservice.data.repository

import bu.ac.kr.movieratingservice.domain.model.User

interface UserRepository {
    suspend fun getUser(): User?

    suspend fun saveUser(user: User)
}