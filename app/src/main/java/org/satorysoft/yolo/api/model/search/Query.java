package org.satorysoft.yolo.api.model.search;

import com.google.gson.annotations.SerializedName;

public final class Query {
    @SerializedName("#text")
    private String queryText;
    @SerializedName("role")
    private String queryRole;
    @SerializedName("searchTerms")
    private String querySearchTerms;
    @SerializedName("startPage")
    private int startPage;

    public Query(){}

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public String getQueryRole() {
        return queryRole;
    }

    public void setQueryRole(String queryRole) {
        this.queryRole = queryRole;
    }

    public String getQuerySearchTerms() {
        return querySearchTerms;
    }

    public void setQuerySearchTerms(String querySearchTerms) {
        this.querySearchTerms = querySearchTerms;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Query query = (Query) o;

        if (startPage != query.startPage) return false;
        if (!queryText.equals(query.queryText)) return false;
        if (!queryRole.equals(query.queryRole)) return false;
        return querySearchTerms.equals(query.querySearchTerms);

    }

    @Override
    public int hashCode() {
        int result = queryText.hashCode();
        result = 31 * result + queryRole.hashCode();
        result = 31 * result + querySearchTerms.hashCode();
        result = 31 * result + startPage;
        return result;
    }

    @Override
    public String toString() {
        return "Query{" +
                "queryText='" + queryText + '\'' +
                ", queryRole='" + queryRole + '\'' +
                ", querySearchTerms='" + querySearchTerms + '\'' +
                ", startPage=" + startPage +
                '}';
    }
}
