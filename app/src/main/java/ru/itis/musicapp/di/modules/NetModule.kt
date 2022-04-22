package ru.itis.musicapp.di.modules

import androidx.viewbinding.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.itis.musicapp.data.api.MusixMatchApi
import ru.itis.musicapp.di.quailfier.ApiKeyInterceptor
import ru.itis.musicapp.di.quailfier.LoggingInterceptor

private const val BASE_URL = "http://api.musixmatch.com/ws/1.1/"
private const val API_KEY_VALUE = "*"
private const val API_KEY_QUERY = "apikey"
@Module(includes = [
    NetBindModule::class
])
class NetModule {

    @Provides
    @ApiKeyInterceptor
    fun provideApiKeyInterceptor(): Interceptor = Interceptor { chain ->
        val original = chain.request()
        val newUrl = original.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_KEY_VALUE)
            .build()

        chain.proceed(
            original.newBuilder()
                .url(newUrl)
                .build()
        )

    }

    @Provides
    @LoggingInterceptor
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(
        @ApiKeyInterceptor apiKeyInterceptor: Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .also {
                if (BuildConfig.DEBUG) {
                    it.addInterceptor(loggingInterceptor)
                }
            }
            .build()

    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJava3CallAdapterFactory.create()

    @Provides
    fun provideMusixMatchApi(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        callAdapterFactory: CallAdapter.Factory
    ) : MusixMatchApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(callAdapterFactory)
        .build()
        .create(MusixMatchApi::class.java)
}

@Module
interface NetBindModule {
    @Binds
    fun provideMapper()
}
