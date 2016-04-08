package org.satorysoft.yolo.api.response;

import com.google.gson.annotations.SerializedName;

import org.satorysoft.yolo.api.model.artist.Artist;

import java.util.List;

public class ArtistResponse {
    @SerializedName("artist")
    private Artist artist;

    public ArtistResponse(){}

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistResponse that = (ArtistResponse) o;

        return artist.equals(that.artist);

    }

    @Override
    public int hashCode() {
        return artist.hashCode();
    }

    @Override
    public String toString() {
        return "ArtistResponse{" +
                "artist=" + artist +
                '}';
    }
}
