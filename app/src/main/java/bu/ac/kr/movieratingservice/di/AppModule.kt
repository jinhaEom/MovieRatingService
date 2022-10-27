package bu.ac.kr.movieratingservice.di

import bu.ac.kr.movieratingservice.data.api.MovieApi
import bu.ac.kr.movieratingservice.data.api.MovieFirestoreApi
import bu.ac.kr.movieratingservice.data.api.ReviewApi
import bu.ac.kr.movieratingservice.data.api.ReviewFirestoreApi
import bu.ac.kr.movieratingservice.data.repository.MovieRepository
import bu.ac.kr.movieratingservice.data.repository.MovieRepositoryImpl
import bu.ac.kr.movieratingservice.data.repository.ReviewRepository
import bu.ac.kr.movieratingservice.data.repository.ReviewRepositoryImpl
import bu.ac.kr.movieratingservice.domain.usecase.GetAllMoviesUseCase
import bu.ac.kr.movieratingservice.domain.usecase.GetRandomFeaturedMovieUseCase
import bu.ac.kr.movieratingservice.presentation.home.HomeContract
import bu.ac.kr.movieratingservice.presentation.home.HomeFragment
import bu.ac.kr.movieratingservice.presentation.home.HomePresenter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO}
}
val dataModule = module {
    single { Firebase.firestore }

    single<MovieApi> {MovieFirestoreApi(get())}
    single<ReviewApi> {ReviewFirestoreApi(get())}

    single<MovieRepository> {MovieRepositoryImpl(get(), get())}
    single<ReviewRepository> {ReviewRepositoryImpl(get(), get())}
}
val domainModule = module{
    factory { GetRandomFeaturedMovieUseCase(get(),get())}
    factory { GetAllMoviesUseCase(get())}
}
val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource(),get(),get())  }
    }
}
