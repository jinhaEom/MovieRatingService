package bu.ac.kr.movieratingservice

import android.app.Application
import bu.ac.kr.movieratingservice.di.appModule
import bu.ac.kr.movieratingservice.di.dataModule
import bu.ac.kr.movieratingservice.di.domainModule
import bu.ac.kr.movieratingservice.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieReviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.DEBUG
                } else {
                    Level.NONE
                }
            )
            androidContext(this@MovieReviewApplication)
            modules(appModule + dataModule + domainModule + presenterModule)
        }
    }
}