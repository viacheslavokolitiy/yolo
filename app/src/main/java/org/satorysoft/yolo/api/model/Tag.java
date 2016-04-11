package org.satorysoft.yolo.api.model;

import com.google.gson.annotations.SerializedName;

public final class Tag {
    @SerializedName("name")
    private String tagName;
    @SerializedName("url")
    private String tagUrl;

    public Tag(){}

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagUrl() {
        return tagUrl;
    }

    public void setTagUrl(String tagUrl) {
        this.tagUrl = tagUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (!tagName.equals(tag.tagName)) return false;
        return tagUrl.equals(tag.tagUrl);

    }

    @Override
    public int hashCode() {
        int result = tagName.hashCode();
        result = 31 * result + tagUrl.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagName='" + tagName + '\'' +
                ", tagUrl='" + tagUrl + '\'' +
                '}';
    }
}
