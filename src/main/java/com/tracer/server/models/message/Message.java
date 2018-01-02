package com.tracer.server.models.message;

import java.sql.Timestamp;

public class Message {
    private long senderID;
    private long groupID;
    private double latitude;
    private double longitude;
    private long dateTime;


    public Message() {
    }

    public Message(long senderID, long groupID, double latitude, double longitude, long dateTime) {
        this.senderID = senderID;
        this.groupID = groupID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateTime = dateTime;
    }

    public long getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public long getSenderID(){
        return this.senderID;
    }

    public void setSenderID(long senderID){
        this.senderID = senderID;
    }

    public long getGroupID(){
        return this.groupID;
    }

    public void setGroupID(long groupID){
        this.groupID = groupID;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
}
