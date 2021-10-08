package com.wizeline.bootcamp.challenge.di

import com.squareup.moshi.Moshi
import com.wizeline.bootcamp.challenge.data.services.PokemonDetailsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val POKEMON_API_BASE_URL = "https://pokeapi.co/api/v2/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(moshi: Moshi): Retrofit {
        val moshiConverterFactory = MoshiConverterFactory.create(moshi)

        return Retrofit.Builder()
            .addConverterFactory(moshiConverterFactory)
            // Uncomment the next line to use Retrofit with RxJava
            // .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(POKEMON_API_BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit): PokemonDetailsService {
        return retrofit.create(PokemonDetailsService::class.java)
    }
}