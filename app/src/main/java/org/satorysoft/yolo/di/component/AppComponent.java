package org.satorysoft.yolo.di.component;

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
import org.satorysoft.yolo.di.module.APIModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {APIModule.class})
@Singleton
public interface AppComponent {

    @NonNull @SuppressWarnings("NullableProblems")
    LastFmAlbumAPI lastFmAlbumAPI();

    @NonNull @SuppressWarnings("NullableProblems")
    LastFmArtistAPI lastFmArtistAPI();

    @NonNull @SuppressWarnings("NullableProblems")
    LastFmChartAPI lastFmChartAPI();

    @NonNull @SuppressWarnings("NullableProblems")
    LastFmGeoApi lastFmGeoApi();

    @NonNull @SuppressWarnings("NullableProblems")
    LastFmLibraryAPI lastFmLibraryApi();

    @NonNull @SuppressWarnings("NullableProblems")
    LastFmTagAPI lastFmTagApi();

    @NonNull @SuppressWarnings("NullableProblems")
    LastFmTrackAPI lastFmTrackApi();

    @NonNull @SuppressWarnings("NullableProblems")
    LastFmUserAPI lastFmUserApi();

    void inject(App app);
}
