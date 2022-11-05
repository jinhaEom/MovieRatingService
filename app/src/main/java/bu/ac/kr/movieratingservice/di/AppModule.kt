package bu.ac.kr.movieratingservice.di

import android.app.Activity
import bu.ac.kr.movieratingservice.data.api.MovieApi
import bu.ac.kr.movieratingservice.data.api.MovieFirestoreApi
import bu.ac.kr.movieratingservice.data.api.ReviewApi
import bu.ac.kr.movieratingservice.data.api.ReviewFirestoreApi
import bu.ac.kr.movieratingservice.data.repository.*
import bu.ac.kr.movieratingservice.domain.model.Movie
import bu.ac.kr.movieratingservice.domain.usecase.GetAllMoviesUseCase
import bu.ac.kr.movieratingservice.domain.usecase.GetAllReviewsUseCase
import bu.ac.kr.movieratingservice.domain.usecase.GetMyReviewedMoviesUseCase
import bu.ac.kr.movieratingservice.domain.usecase.GetRandomFeaturedMovieUseCase
import bu.ac.kr.movieratingservice.preference.PreferenceManager
import bu.ac.kr.movieratingservice.preference.SharedPreferenceManager
import bu.ac.kr.movieratingservice.presentation.home.HomeContract
import bu.ac.kr.movieratingservice.presentation.home.HomeFragment
import bu.ac.kr.movieratingservice.presentation.home.HomePresenter
import bu.ac.kr.movieratingservice.presentation.review.MovieReviewsContract
import bu.ac.kr.movieratingservice.presentation.review.MovieReviewsFragment
import bu.ac.kr.movieratingservice.presentation.review.MovieReviewsPresenter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
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
    single<UserRepository> { UserRepositoryImpl(get(), get(), get())}

    single { androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE) }
    single<PreferenceManager> { SharedPreferenceManager(get())}
}
val domainModule = module{
    factory { GetRandomFeaturedMovieUseCase(get(),get())}
    factory { GetAllMoviesUseCase(get())}
    factory { GetAllReviewsUseCase(get())}
    factory { GetMyReviewedMoviesUseCase(get(), get() ,get())}
}
val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource(),get(),get())  }
    }
    scope<MovieReviewsFragment>{
        scoped<MovieReviewsContract.Presenter> { (movie: Movie) -> MovieReviewsPresenter(getSource(), movie, get())}
    }
}
