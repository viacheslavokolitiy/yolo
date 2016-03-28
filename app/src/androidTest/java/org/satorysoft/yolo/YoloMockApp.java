package org.satorysoft.yolo;

import android.support.annotation.NonNull;

import org.satorysoft.yolo.di.component.AppComponent;
import org.satorysoft.yolo.di.component.DaggerAppComponent;
import org.satorysoft.yolo.di.module.APIModule;
import org.satorysoft.yolo.di.module.AppModule;

public class YoloMockApp extends App {
    private DaggerAppComponent.Builder builder;
    private AppComponent component;

    @NonNull
    @Override
    protected DaggerAppComponent.Builder buildDaggerComponent() {
        builder = super.buildDaggerComponent()
                .appModule(new AppModule())
                .aPIModule(new APIModule(App.ENDPOINT));

        component = builder.build();
        component.inject(this);
        component.lastFmAlbumAPI();
        component.lastFmArtistAPI();
        component.lastFmChartAPI();
        component.lastFmGeoApi();
        component.lastFmUserApi();
        component.lastFmLibraryApi();
        component.lastFmTagApi();
        component.lastFmTrackApi();

        return builder;
    }
}
