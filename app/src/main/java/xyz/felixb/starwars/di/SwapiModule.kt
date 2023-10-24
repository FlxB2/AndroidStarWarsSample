package xyz.felixb.starwars.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.swapi.client.apis.DefaultApi
import dev.swapi.client.infrastructure.ApiClient
import javax.inject.Singleton

/**
 * Module to provide the Swapi API via Hilt.
 */
@InstallIn(SingletonComponent::class)
@Module
class SwapiModule {

    @Singleton
    @Provides
    fun provideSwapiApi(): DefaultApi {
        /**
         * In a real application authentication, caching etc would be
         * handled in a separate file which creates the client.
         */
        return ApiClient()
            .setLogger { m -> Log.i("API", m) }
            .createService(DefaultApi::class.java)
    }
}