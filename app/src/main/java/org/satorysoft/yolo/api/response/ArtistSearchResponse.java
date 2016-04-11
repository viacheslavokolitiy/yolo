package org.satorysoft.yolo.api.response;

import com.google.gson.annotations.SerializedName;

import org.satorysoft.yolo.api.model.artist.ArtistSearchResult;

public final class ArtistSearchResponse {

    @SerializedName("results")
    private ArtistSearchResult artistSearchResult;

    public ArtistSearchResponse(){}

    public ArtistSearchResult getArtistSearchResult() {
        return artistSearchResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistSearchResponse that = (ArtistSearchResponse) o;

        return artistSearchResult.equals(that.artistSearchResult);

    }

    @Override
    public int hashCode() {
        return artistSearchResult.hashCode();
    }

    @Override
    public String toString() {
        return "ArtistSearchResponse{" +
                "artistSearchResult=" + artistSearchResult +
                '}';
    }
}
