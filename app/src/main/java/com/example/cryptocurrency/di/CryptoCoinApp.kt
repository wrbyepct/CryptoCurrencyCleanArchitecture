package com.example.cryptocurrency.di

import com.example.cryptocurrency.core.Constants
import com.example.cryptocurrency.data.remote.CoinPaprikaApi
import com.example.cryptocurrency.data.repository.CoinRepositoryImpl
import com.example.cryptocurrency.domain.repository.CoinRepository
import com.example.cryptocurrency.domain.usecases.CoinUseCases
import com.example.cryptocurrency.domain.usecases.get_coin.GetCoin
import com.example.cryptocurrency.domain.usecases.get_coins.GetCoins
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CryptoCoinApp {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}