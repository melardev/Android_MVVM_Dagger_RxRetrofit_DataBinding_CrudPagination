package com.melardev.android.crud.datasource.remote.dtos.responses;

import com.google.gson.annotations.SerializedName;

public class PageMeta {

    @SerializedName("has_next_page")
    private boolean hasNextPage;
    @SerializedName("has_prev_page")
    private boolean hasPrevPage;
    @SerializedName("current_page_number")
    public int currentPageNumber;
    @SerializedName("total_items_count")
    private long totalItemsCount; // total todos in total
    @SerializedName("requested_page_size")
    private int requestedPageSize; // max todos per page
    @SerializedName("current_items_count")
    private int currentItemsCount; // todos in this page
    @SerializedName("number_of_pages")
    private int numberOfPages; // number of pages
    @SerializedName("offset")
    private long offset;
    @SerializedName("next_page_number")
    private int nextPageNumber;
    @SerializedName("prev_page_number")
    private int prevPageNumber;
    @SerializedName("next_page_url")
    private String nextPageUrl;
    @SerializedName("prev_page_url")
    private String prevPageUrl;

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPrevPage() {
        return hasPrevPage;
    }

    public void setHasPrevPage(boolean hasPrevPage) {
        this.hasPrevPage = hasPrevPage;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public long getTotalItemsCount() {
        return totalItemsCount;
    }

    public void setTotalItemsCount(long totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }

    public int getRequestedPageSize() {
        return requestedPageSize;
    }

    public void setRequestedPageSize(int requestedPageSize) {
        this.requestedPageSize = requestedPageSize;
    }

    public int getCurrentItemsCount() {
        return currentItemsCount;
    }

    public void setCurrentItemsCount(int currentItemsCount) {
        this.currentItemsCount = currentItemsCount;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(int nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public int getPrevPageNumber() {
        return prevPageNumber;
    }

    public void setPrevPageNumber(int prevPageNumber) {
        this.prevPageNumber = prevPageNumber;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }
}
