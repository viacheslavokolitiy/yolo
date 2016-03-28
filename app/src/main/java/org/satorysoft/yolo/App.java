package org.satorysoft.yolo;

import android.app.Application;
import android.support.annotation.NonNull;

import org.satorysoft.yolo.di.component.AppComponent;
import org.satorysoft.yolo.di.component.DaggerAppComponent;
import org.satorysoft.yolo.di.module.APIModule;
import org.satorysoft.yolo.di.module.AppModule;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class App extends Application {

    private static App instance;

    public static final String ENDPOINT = "http://ws.audioscrobbler.com/2.0/";

    @SuppressWarnings("NullableProblems")
    @Inject @NonNull
    protected Retrofit retrofit;
    private AppComponent component;

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate() {
        super.onCreate();
        instance = this;

        component = buildDaggerComponent().build();
        component.inject(this);
    }

    @NonNull
    public static App getAppInstance() {
        return instance;
    }

    @NonNull
    protected DaggerAppComponent.Builder buildDaggerComponent() {
        return DaggerAppComponent.
                builder()
                .aPIModule(new APIModule(ENDPOINT))
                .appModule(new AppModule());
    }

    @NonNull
    public AppComponent getComponent() {
        return component;
    }
}
