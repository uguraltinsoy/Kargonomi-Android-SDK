package com.deeplabstudio.kargonomisdk.Models.Shipment;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ShipmentListResponse {

    @SerializedName("data")
    private List<ShipmentDetailResponse> data;

    @SerializedName("links")
    private Links links;

    @SerializedName("meta")
    private Meta meta;

    public List<ShipmentDetailResponse> getData() {
        return data;
    }

    public Links getLinks() {
        return links;
    }

    public Meta getMeta() {
        return meta;
    }

    public static class Links {
        @SerializedName("first")
        private String first;

        @SerializedName("last")
        private String last;

        @SerializedName("prev")
        private String prev;

        @SerializedName("next")
        private String next;

        public String getFirst() { return first; }
        public String getLast() { return last; }
        public String getPrev() { return prev; }
        public String getNext() { return next; }
    }

    public static class Meta {

        @SerializedName("current_page")
        private int currentPage;

        @SerializedName("from")
        private int from;

        @SerializedName("last_page")
        private int lastPage;

        @SerializedName("links")
        private List<PageLink> links;

        @SerializedName("path")
        private String path;

        @SerializedName("per_page")
        private int perPage;

        @SerializedName("to")
        private int to;

        @SerializedName("total")
        private int total;

        public int getCurrentPage() { return currentPage; }
        public int getFrom() { return from; }
        public int getLastPage() { return lastPage; }
        public List<PageLink> getLinks() { return links; }
        public String getPath() { return path; }
        public int getPerPage() { return perPage; }
        public int getTo() { return to; }
        public int getTotal() { return total; }
    }

    public static class PageLink {

        @SerializedName("url")
        private String url;

        @SerializedName("label")
        private String label;

        @SerializedName("active")
        private boolean active;

        public String getUrl() { return url; }
        public String getLabel() { return label; }
        public boolean isActive() { return active; }
    }
}

