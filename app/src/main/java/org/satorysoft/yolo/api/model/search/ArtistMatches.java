package org.satorysoft.yolo.api.model.search;

import com.google.gson.annotations.SerializedName;

import org.satorysoft.yolo.api.model.artist.Artist;

import java.util.Arrays;

public class ArtistMatches {

    @SerializedName("artist")
    private Artist[] artist;

    public ArtistMatches(){}

    public Artist[] getArtist() {
        return artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistMatches that = (ArtistMatches) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(artist, that.artist);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(artist);
    }

    @Override
    public String toString() {
        return "ArtistMatches{" +
                "artist=" + Arrays.toString(artist) +
                '}';
    }
}
