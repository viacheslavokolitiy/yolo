package org.satorysoft.yolo.api.model.artist;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public final class SimilarArtist {
    @SerializedName("name")
    private String artistName;
    @SerializedName("url")
    private String artistURL;
    @SerializedName("image")
    private ArtistImage[] images;

    public SimilarArtist(){}

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistURL() {
        return artistURL;
    }

    public void setArtistURL(String artistURL) {
        this.artistURL = artistURL;
    }

    public ArtistImage[] getImages() {
        return images;
    }

    public void setImages(ArtistImage[] images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimilarArtist that = (SimilarArtist) o;

        if (!artistName.equals(that.artistName)) return false;
        if (!artistURL.equals(that.artistURL)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(images, that.images);

    }

    @Override
    public int hashCode() {
        int result = artistName.hashCode();
        result = 31 * result + artistURL.hashCode();
        result = 31 * result + Arrays.hashCode(images);
        return result;
    }

    @Override
    public String toString() {
        return "SimilarArtist{" +
                "artistName='" + artistName + '\'' +
                ", artistURL='" + artistURL + '\'' +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}
