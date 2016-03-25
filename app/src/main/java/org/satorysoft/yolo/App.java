package org.satorysoft.yolo;

import android.app.Application;

import org.satorysoft.yolo.di.component.DaggerAPIComponent;
import org.satorysoft.yolo.di.module.APIModule;
import org.satorysoft.yolo.di.module.AppModule;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by vokol on 25.03.2016.
 */
public class App extends Application {

    private static App instance;

    private static final String ENDPOINT = "http://ws.audioscrobbler.com/2.0";

    @Inject
    protected Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        DaggerAPIComponent.
                builder()
                .aPIModule(new APIModule(ENDPOINT))
                .appModule(new AppModule())
                .build()
                .inject(this);
    }

    public static App getAppInstance(){
        return instance;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
