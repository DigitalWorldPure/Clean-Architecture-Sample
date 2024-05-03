package com.example.data.net.di

import com.example.data.net.POKEMON_API_URL
import com.example.data.net.client.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {
    @Provides
    fun provideApiClient(client: OkHttpClient): ApiClient {
        return ApiClient(POKEMON_API_URL, client)
    }
}