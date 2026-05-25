package com.goteborgaren.app.di

import com.goteborgaren.app.data.repository.DepartureRepository
import com.goteborgaren.app.data.repository.PlaceRepository
import com.goteborgaren.app.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDepartureRepository(): DepartureRepository = DepartureRepository()

    @Provides
    @Singleton
    fun provideWeatherRepository(): WeatherRepository = WeatherRepository()

    @Provides
    @Singleton
    fun providePlaceRepository(): PlaceRepository = PlaceRepository()
}
