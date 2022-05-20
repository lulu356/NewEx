package com.example.newex.HotelDB;

import java.util.Date;

public class Message {
    public String idmess, generatedmessId ,MessageTime, UserId, User, TextMessage;

    public Message() {
    }

    public Message(String idmess, String generatedmessId, String MessageTime, String UserId, String User, String TextMessage) {
        this.idmess = idmess;
        this.generatedmessId = generatedmessId;
        this.MessageTime = MessageTime;
        this.UserId = UserId;
        this.User = User;
        this.TextMessage = TextMessage;
    }}
