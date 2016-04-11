package org.satorysoft.yolo.api.model.artist;

import com.google.gson.annotations.SerializedName;

import org.satorysoft.yolo.api.model.search.ArtistMatches;
import org.satorysoft.yolo.api.model.search.Query;
import org.satorysoft.yolo.api.model.search.SearchAttribute;

public class ArtistSearchResult {

    @SerializedName("opensearch:Query")
    private Query openSearchQuery;
    @SerializedName("opensearch:totalResults")
    private int totalResults;
    @SerializedName("opensearch:startIndex")
    private int startIndex;
    @SerializedName("opensearch:itemsPerPage")
    private int itemsPerPage;
    @SerializedName("artistmatches")
    private ArtistMatches artistMatches;
    @SerializedName("@attr")
    private SearchAttribute searchAttribute;

    public ArtistSearchResult(){}

    public Query getOpenSearchQuery() {
        return openSearchQuery;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public ArtistMatches getArtistMatches() {
        return artistMatches;
    }

    public SearchAttribute getSearchAttribute() {
        return searchAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistSearchResult that = (ArtistSearchResult) o;

        if (totalResults != that.totalResults) return false;
        if (startIndex != that.startIndex) return false;
        if (itemsPerPage != that.itemsPerPage) return false;
        if (!openSearchQuery.equals(that.openSearchQuery)) return false;
        if (!artistMatches.equals(that.artistMatches)) return false;
        return searchAttribute.equals(that.searchAttribute);

    }

    @Override
    public int hashCode() {
        int result = openSearchQuery.hashCode();
        result = 31 * result + totalResults;
        result = 31 * result + startIndex;
        result = 31 * result + itemsPerPage;
        result = 31 * result + artistMatches.hashCode();
        result = 31 * result + searchAttribute.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ArtistSearchResult{" +
                "openSearchQuery=" + openSearchQuery +
                ", totalResults=" + totalResults +
                ", startIndex=" + startIndex +
                ", itemsPerPage=" + itemsPerPage +
                ", artistMatches=" + artistMatches +
                ", searchAttribute=" + searchAttribute +
                '}';
    }
}
