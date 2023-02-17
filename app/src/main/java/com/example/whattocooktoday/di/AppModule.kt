package com.example.whattocooktoday.di

import com.example.whattocooktoday.network.RecipeApi
import com.example.whattocooktoday.repository.RecipeRepository
import com.example.whattocooktoday.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(api: RecipeApi) = RecipeRepository(api)

    @Singleton
    @Provides
    fun provideRecipeApi(): RecipeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }

}