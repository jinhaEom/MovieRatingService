package bu.ac.kr.movieratingservice.domain.model

import com.google.firebase.firestore.DocumentId

data class User(

    @DocumentId
    val id : String? =null
)