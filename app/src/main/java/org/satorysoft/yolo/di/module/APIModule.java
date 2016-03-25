package org.satorysoft.yolo.di.module;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
}
