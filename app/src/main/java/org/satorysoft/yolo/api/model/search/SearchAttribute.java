package org.satorysoft.yolo.api.model.search;

import com.google.gson.annotations.SerializedName;

public class SearchAttribute {
    @SerializedName("for")
    private String searchFor;

    public SearchAttribute(){}

    public String getSearchFor() {
        return searchFor;
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
