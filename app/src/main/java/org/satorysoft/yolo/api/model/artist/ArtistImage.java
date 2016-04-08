package org.satorysoft.yolo.api.model.artist;

import com.google.gson.annotations.SerializedName;

public class ArtistImage {
    @SerializedName("#text")
    private String text;
    @SerializedName("size")
    private String imageSize;

    public ArtistImage(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistImage that = (ArtistImage) o;

        if (!text.equals(that.text)) return false;
        return imageSize.equals(that.imageSize);

    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + imageSize.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ArtistImage{" +
                "text='" + text + '\'' +
                ", imageSize='" + imageSize + '\'' +
                '}';
    }
}
