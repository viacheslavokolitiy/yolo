package org.satorysoft.yolo;

import android.support.annotation.NonNull;

import org.satorysoft.yolo.di.component.AppComponent;
import org.satorysoft.yolo.di.component.DaggerAppComponent;
import org.satorysoft.yolo.di.module.APIModule;
import org.satorysoft.yolo.di.module.AppModule;


/**
 * Created by vokol on 28.03.2016.
 */
public class YoloMockApp extends App {

    @NonNull
    @Override
    protected DaggerAppComponent.Builder buildDaggerComponent() {
        return super.buildDaggerComponent()
                .appModule(new AppModule())
                .aPIModule(new APIModule(App.ENDPOINT));
    }

    @NonNull
    @Override
    public AppComponent getComponent() {
        return super.getComponent();
    }
}
