package org.satorysoft.yolo.di.module;

import android.support.annotation.NonNull;

import org.satorysoft.yolo.App;
import org.satorysoft.yolo.api.LastFmAlbumAPI;
import org.satorysoft.yolo.api.LastFmArtistAPI;
import org.satorysoft.yolo.api.LastFmChartAPI;
import org.satorysoft.yolo.api.LastFmGeoApi;
import org.satorysoft.yolo.api.LastFmLibraryAPI;
import org.satorysoft.yolo.api.LastFmTagAPI;
import org.satorysoft.yolo.api.LastFmTrackAPI;
import org.satorysoft.yolo.api.LastFmUserAPI;
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

    @Provides @Singleton
    public LastFmAlbumAPI provideAlbumAPI(){
        final Retrofit retrofit = buildRetrofitAdapter();

        return retrofit.create(LastFmAlbumAPI.class);
    }

    @Provides @Singleton
    public LastFmArtistAPI provideArtistAPI(){
        final Retrofit retrofit = buildRetrofitAdapter();

        return retrofit.create(LastFmArtistAPI.class);
    }

    @Provides @Singleton
    public LastFmChartAPI provideChartAPI(){
        final Retrofit retrofit = buildRetrofitAdapter();

        return retrofit.create(LastFmChartAPI.class);
    }

    @Provides @Singleton
    public LastFmGeoApi provideGeoAPI(){
        final Retrofit retrofit = buildRetrofitAdapter();

        return retrofit.create(LastFmGeoApi.class);
    }

    @Provides @Singleton
    public LastFmLibraryAPI provideLibraryAPI(){
        final Retrofit retrofit = buildRetrofitAdapter();

        return retrofit.create(LastFmLibraryAPI.class);
    }

    @Provides @Singleton
    public LastFmTagAPI provideTagAPI(){
        final Retrofit retrofit = buildRetrofitAdapter();

        return retrofit.create(LastFmTagAPI.class);
    }

    @Provides @Singleton
    public LastFmTrackAPI provideTrackAPI(){
        final Retrofit retrofit = buildRetrofitAdapter();

        return retrofit.create(LastFmTrackAPI.class);
    }

    @Provides @Singleton
    public LastFmUserAPI provideUserAPI(){
        final Retrofit retrofit = buildRetrofitAdapter();

        return retrofit.create(LastFmUserAPI.class);
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
