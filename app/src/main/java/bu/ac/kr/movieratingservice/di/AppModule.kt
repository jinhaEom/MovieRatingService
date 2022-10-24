package bu.ac.kr.movieratingservice.di

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module


val appModule = module {
    single { Firebase.firestore }

}
