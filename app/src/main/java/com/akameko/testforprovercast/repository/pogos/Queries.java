package com.akameko.testforprovercast.repository.pogos;

import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Queries {

    @SerializedName("request")
    @Expose
    private List<Request> request = null;
    @SerializedName("nextPage")
    @Expose
    private List<NextPage> nextPage = null;

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    public List<NextPage> getNextPage() {
        return nextPage;
    }

    public void setNextPage(List<NextPage> nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    public String toString() {
        return "Queries{" +
                "request=" + request +
                ", nextPage=" + nextPage +
                '}';
    }
}