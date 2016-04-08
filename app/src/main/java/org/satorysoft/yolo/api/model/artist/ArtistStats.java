package org.satorysoft.yolo.api.model.artist;

import com.google.gson.annotations.SerializedName;

public class ArtistStats {
    @SerializedName("listeners")
    private String listeners;
    @SerializedName("playcount")
    private String playCount;

    public ArtistStats(){}

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistStats that = (ArtistStats) o;

        if (!listeners.equals(that.listeners)) return false;
        return playCount.equals(that.playCount);

    }

    @Override
    public int hashCode() {
        int result = listeners.hashCode();
        result = 31 * result + playCount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ArtistStats{" +
                "listeners='" + listeners + '\'' +
                ", playCount='" + playCount + '\'' +
                '}';
    }
}
