package com.example.newex.Model;

public class serviceData {
    String serviceName;
    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public serviceData(String placeName, Integer imageUrl) {
        this.serviceName = placeName;
        this.imageUrl = imageUrl;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setPlaceName(String placeName) {
        this.serviceName = placeName;
    }


}
