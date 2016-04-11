package org.satorysoft.yolo.api.model;

import com.google.gson.annotations.SerializedName;

public final class Link {
    @SerializedName("#text")
    private String linkText;
    @SerializedName("rel")
    private String relation;
    @SerializedName("href")
    private String ref;

    public Link(){}

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!linkText.equals(link.linkText)) return false;
        if (!relation.equals(link.relation)) return false;
        return ref.equals(link.ref);

    }

    @Override
    public int hashCode() {
        int result = linkText.hashCode();
        result = 31 * result + relation.hashCode();
        result = 31 * result + ref.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkText='" + linkText + '\'' +
                ", relation='" + relation + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}
