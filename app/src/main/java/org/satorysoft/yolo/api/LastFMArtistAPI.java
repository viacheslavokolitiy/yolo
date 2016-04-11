package org.satorysoft.yolo.api;

import android.support.annotation.NonNull;

import org.satorysoft.yolo.api.response.ArtistResponse;
import org.satorysoft.yolo.api.response.ArtistSearchResponse;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface LastFMArtistAPI {

    String ARTIST_INFO = "?method=artist.getinfo&api_key=e041e9a00fbcb8acf3fa71a7711b9c0c&format=json";
    String ARTIST_SEARCH = "?method=artist.search&api_key=e041e9a00fbcb8acf3fa71a7711b9c0c&format=json";

    @GET(ARTIST_INFO)
    Observable<ArtistResponse> artistInfo(@NonNull @Query("artist") String artistName);

    @GET(ARTIST_SEARCH)
    Observable<ArtistSearchResponse> getArtistMatch(@NonNull @Query("artist") String artistName);
}
