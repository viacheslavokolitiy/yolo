package org.satorysoft.yolo;

import android.app.Application;
import android.support.annotation.NonNull;

import org.satorysoft.yolo.di.component.APIComponent;
import org.satorysoft.yolo.di.component.DaggerAPIComponent;
import org.satorysoft.yolo.di.module.APIModule;
import org.satorysoft.yolo.di.module.AppModule;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class App extends Application {

    private static App instance;

    public static final String ENDPOINT = "http://ws.audioscrobbler.com/2.0/";

    @Inject
    protected Retrofit retrofit;

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate() {
        super.onCreate();
        instance = this;

        APIComponent component = buildDaggerComponent().build();
        component.inject(this);
    }

    public static App getAppInstance(){
        return instance;
    }

    @NonNull
    protected DaggerAPIComponent.Builder buildDaggerComponent(){
        return DaggerAPIComponent.
                builder()
                .aPIModule(new APIModule(ENDPOINT))
                .appModule(new AppModule());
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
