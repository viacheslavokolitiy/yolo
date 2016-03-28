package org.satorysoft.yolo;

import android.support.annotation.NonNull;

import org.satorysoft.yolo.di.component.DaggerAPIComponent;
import org.satorysoft.yolo.di.module.APIModule;
import org.satorysoft.yolo.di.module.AppModule;

/**
 * Created by vokol on 28.03.2016.
 */
public class YoloMockApp extends App {

    @NonNull
    @Override
    protected DaggerAPIComponent.Builder buildDaggerComponent() {
        return super.buildDaggerComponent()
                .appModule(new AppModule())
                .aPIModule(new APIModule(App.ENDPOINT));
    }
}
