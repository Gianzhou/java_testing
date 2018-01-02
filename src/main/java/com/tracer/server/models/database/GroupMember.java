package com.tracer.server.models.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_member")
public class GroupMember {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne //error here if json ignore is removed
    @JsonIgnore
    private Group group;

    @OneToMany(mappedBy = "groupMemberId")
    private List<Point> points;

    private long color;

    public GroupMember(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Group getGroup(){
        return this.group;
    }

    public void setGroup(Group group){
        this.group = group;
    }

    public List<Point> getPoints(){
        return this.points;
    }

    public void setPoints(List<Point> points){
        this.points = points;
    }

    public long getColor(){
        return this.color;
    }

    public void setColor(long color){
        this.color = color;
    }


}
