package com.example.newex.Model;

public class recentsData {
    String RoomTitle;
    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public recentsData(String RoomTitle, Integer imageUrl) {
        this.RoomTitle = RoomTitle;
        this.imageUrl=imageUrl;
    }

    public String getRoomTitle() {
        return RoomTitle;
    }

    public void setRoomTitle(String RoomTitle) {
        this.RoomTitle = RoomTitle;
    }
}

