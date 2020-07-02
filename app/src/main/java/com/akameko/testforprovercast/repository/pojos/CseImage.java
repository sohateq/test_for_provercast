package com.akameko.testforprovercast.repository.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CseImage {

    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("height")
    @Expose
    private String height;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}