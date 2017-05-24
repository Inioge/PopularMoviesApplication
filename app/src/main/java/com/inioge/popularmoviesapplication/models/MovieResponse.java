package com.inioge.popularmoviesapplication.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ADMIN on 24/05/2017.
 */
public class MovieResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<MovieData> results;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public List<MovieData> getResults() {
        return results;
    }

    public void setResults(List<MovieData> results) {
        this.results = results;
    }
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

}
