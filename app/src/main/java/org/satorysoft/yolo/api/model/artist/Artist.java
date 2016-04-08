package org.satorysoft.yolo.api.model.artist;

import com.google.gson.annotations.SerializedName;

import org.satorysoft.yolo.api.model.Tag;

import java.util.Arrays;

public class Artist {
    @SerializedName("name")
    private String artistName;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private ArtistImage[] artistImage;
    @SerializedName("streamable")
    private boolean isStreamable;
    @SerializedName("ontour")
    private boolean isOnTour;
    @SerializedName("stats")
    private ArtistStats artistStats;
    @SerializedName("similar")
    private SimilarArtist similarArtists;
    @SerializedName("tags")
    private Tag artistTags;
    @SerializedName("bio")
    private ArtistBio artistBio;

    public Artist(){}

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArtistImage[] getArtistImage() {
        return artistImage;
    }

    public void setArtistImage(ArtistImage[] artistImage) {
        this.artistImage = artistImage;
    }

    public boolean isStreamable() {
        return isStreamable;
    }

    public void setStreamable(boolean streamable) {
        isStreamable = streamable;
    }

    public boolean isOnTour() {
        return isOnTour;
    }

    public void setOnTour(boolean onTour) {
        isOnTour = onTour;
    }

    public ArtistStats getArtistStats() {
        return artistStats;
    }

    public void setArtistStats(ArtistStats artistStats) {
        this.artistStats = artistStats;
    }

    public SimilarArtist getSimilarArtists() {
        return similarArtists;
    }

    public void setSimilarArtists(SimilarArtist similarArtists) {
        this.similarArtists = similarArtists;
    }

    public Tag getArtistTags() {
        return artistTags;
    }

    public void setArtistTags(Tag artistTags) {
        this.artistTags = artistTags;
    }

    public ArtistBio getArtistBio() {
        return artistBio;
    }

    public void setArtistBio(ArtistBio artistBio) {
        this.artistBio = artistBio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (isStreamable != artist.isStreamable) return false;
        if (isOnTour != artist.isOnTour) return false;
        if (!artistName.equals(artist.artistName)) return false;
        if (!mbid.equals(artist.mbid)) return false;
        if (!url.equals(artist.url)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(artistImage, artist.artistImage)) return false;
        if (!artistStats.equals(artist.artistStats)) return false;
        if (!similarArtists.equals(artist.similarArtists)) return false;
        if (!artistTags.equals(artist.artistTags)) return false;
        return artistBio.equals(artist.artistBio);

    }

    @Override
    public int hashCode() {
        int result = artistName.hashCode();
        result = 31 * result + mbid.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + Arrays.hashCode(artistImage);
        result = 31 * result + (isStreamable ? 1 : 0);
        result = 31 * result + (isOnTour ? 1 : 0);
        result = 31 * result + artistStats.hashCode();
        result = 31 * result + similarArtists.hashCode();
        result = 31 * result + artistTags.hashCode();
        result = 31 * result + artistBio.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistName='" + artistName + '\'' +
                ", mbid='" + mbid + '\'' +
                ", url='" + url + '\'' +
                ", artistImage=" + Arrays.toString(artistImage) +
                ", isStreamable=" + isStreamable +
                ", isOnTour=" + isOnTour +
                ", artistStats=" + artistStats +
                ", similarArtists=" + similarArtists +
                ", artistTags=" + artistTags +
                ", artistBio=" + artistBio +
                '}';
    }
}
