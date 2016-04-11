package org.satorysoft.yolo.api.model.search;

import com.google.gson.annotations.SerializedName;

public final class SearchAttribute {
    @SerializedName("for")
    private String searchFor;

    public SearchAttribute(){}

    public String getSearchFor() {
        return searchFor;
    }

    public void setSearchFor(String searchFor) {
        this.searchFor = searchFor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchAttribute that = (SearchAttribute) o;

        return searchFor.equals(that.searchFor);

    }

    @Override
    public int hashCode() {
        return searchFor.hashCode();
    }

    @Override
    public String toString() {
        return "SearchAttribute{" +
                "searchFor='" + searchFor + '\'' +
                '}';
    }
}
