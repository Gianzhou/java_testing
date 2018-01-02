package com.tracer.server.models.database;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy="group")
    private List<GroupMember> members;

    public Group(){}

    public long getID(){
        return this.id;
    }

    public void setID(long id){
        this.id = id;
    }

    public List<GroupMember> getMembers(){
        return this.members;
    }
}
