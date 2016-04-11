package org.satorysoft.yolo.di.module;

import android.support.annotation.NonNull;

import org.satorysoft.yolo.App;
import org.satorysoft.yolo.util.LastFmRequestInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module(includes = {AppModule.class})
public class APIModule {
    private final String endPointURL;

    public APIModule(@NonNull String endPointURL) {
        this.endPointURL = endPointURL;
    }

    @Provides @Singleton
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder().baseUrl(endPointURL).build();
    }

    @NonNull
    public Retrofit buildRetrofitAdapter() {
        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LastFmRequestInterceptor()).build();

        return new Retrofit
                .Builder()
                .baseUrl(App.ENDPOINT)
                .client(defaultHttpClient).build();
    }
}
