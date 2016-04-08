package org.satorysoft.yolo.api.model.artist;

import com.google.gson.annotations.SerializedName;

import org.satorysoft.yolo.api.model.Link;

import java.util.Date;

public class ArtistBio {
    @SerializedName("links")
    private Link bioLinks;
    @SerializedName("published")
    private String published;
    @SerializedName("summary")
    private String summary;
    @SerializedName("content")
    private String content;

    public ArtistBio(){}

    public Link getBioLinks() {
        return bioLinks;
    }

    public void setBioLinks(Link bioLinks) {
        this.bioLinks = bioLinks;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistBio artistBio = (ArtistBio) o;

        if (!bioLinks.equals(artistBio.bioLinks)) return false;
        if (!published.equals(artistBio.published)) return false;
        if (!summary.equals(artistBio.summary)) return false;
        return content.equals(artistBio.content);

    }

    @Override
    public int hashCode() {
        int result = bioLinks.hashCode();
        result = 31 * result + published.hashCode();
        result = 31 * result + summary.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ArtistBio{" +
                "bioLinks=" + bioLinks +
                ", published='" + published + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
