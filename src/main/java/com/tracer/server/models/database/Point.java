package com.tracer.server.models.database;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="group_member_id")
    private long groupMemberId;

    @Column(name="group_id")
    private long groupId;

    private double latitude;

    private double longitude;

    private Timestamp dateTime;

    public Point(){}

    public Point(long groupID, long groupMemberID, double latitude, double longitude, Timestamp dateTime){
        this.groupId = groupID;
        this.groupMemberId = groupMemberID;
        this.latitude = latitude;
        this.longitude = longitude;
    //    this.dateTime = Timestamp.from(Instant.now());
        this.dateTime = dateTime;
    }

    public Timestamp getDateTime() {
    	return this.dateTime;
    }
    public long getID(){
        return this.id;
    }

    public void setID(long id){
        this.id = id;
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

    public long getGroupID(){
        return this.groupId;
    }

    public void setGroupID(long groupID){
        this.groupId = groupID;
    }

    public long getGroupMemberID(){
        return this.groupMemberId;
    }

    public void setGroupMemberID(long groupMemberID){
        this.groupMemberId = groupMemberID;
    }

    public double distanceFrom(Point point) {
        double lat1 = (float)this.getLatitude();
        double lng1 = (float)this.getLongitude();

        double lat2 = (float)point.getLatitude();
        double lng2 = (float)point.getLongitude();

        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }

}
