package xyz.felixb.starwars.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.swapi.client.apis.DefaultApi
import dev.swapi.client.infrastructure.ApiClient
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SwapiModule {

    @Singleton
    @Provides
    fun provideSwapiApi(): DefaultApi {
        return ApiClient()
            .setLogger { m -> Log.i("API", m) }
            .createService(DefaultApi::class.java)
    }
}