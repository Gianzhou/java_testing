package com.tracer.server.controllers;

import com.tracer.server.models.database.Group;
import com.tracer.server.models.database.GroupMember;
import com.tracer.server.repositories.GroupMemberRepository;
import com.tracer.server.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
// CHANGE@171030: use a constant end-point because mixing singular and plural is confusing...
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;
    
    // CHANGE@171030: no additional mapping needed as this is the root of the 'groups' end-point
    // TO-DO: this method should not deliver nested collection (members)
    @RequestMapping("")
    @ResponseBody
    public List<Group> getGroups(){
        Iterator<Group> items = groupRepository.findAll().iterator();
        List<Group> list = new ArrayList<>();

        while (items.hasNext()) {
            list.add(items.next());
        }

        return list;
    }

    // CHANGE@171030
    @RequestMapping("/{groupID}")
    @ResponseBody
    public Group getGroup(@PathVariable("groupID") long groupID){
        return groupRepository.findOne(groupID);
    }

    // CHANGE@171030
    @RequestMapping("/{groupID}/member/{userID}")
    @ResponseBody
    public GroupMember getGroupMember(@PathVariable("groupID") long groupID, @PathVariable("userID") long userID){
        return groupMemberRepository.findOneByUserIdAndGroupId(userID, groupID);
    }
}
