package com.tracer.server.controllers;

import com.tracer.server.models.database.Group;
import com.tracer.server.models.database.GroupMember;
import com.tracer.server.models.message.Message;
import com.tracer.server.models.database.Point;
import com.tracer.server.models.message.RequestMessage;
import com.tracer.server.models.message.ResponseMessage;
import com.tracer.server.repositories.GroupMemberRepository;
import com.tracer.server.repositories.GroupRepository;
import com.tracer.server.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;

import java.util.List;


@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;
    @Autowired
    private GroupRepository groupRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        return new String("Welcome");
    }

    @MessageMapping("/{groupID}/changeLocation")
    public void changeLocation(@Payload RequestMessage requestMessage, @DestinationVariable long groupID) {
        long user_id = requestMessage.getSenderID();
        long group_id = requestMessage.getGroupID();
        double latitude = requestMessage.getLatitude();
        double longitude = requestMessage.getLongitude();
        long dateTime = requestMessage.getDateTime();
        boolean insert = false;

        GroupMember member = groupMemberRepository.findOne(user_id);
        Group group = groupRepository.findOne(group_id);

        Point newPoint = new Point(group.getID(), member.getId(), latitude, longitude, new Timestamp(dateTime));
        List<Point> points = pointRepository.findAllByGroupIdAndGroupMemberId(group_id, user_id);
        if (points.size() > 0) {
            // Get distance between two points
            Point lastPoint = points.get(points.size() - 1);

            // In meters
            double distance = newPoint.distanceFrom(lastPoint);
            
            // Lowered distance limit from 100m to 15m (for presentation purposes)
            // Note: the margin of error for GPS fine location tracking is ~10m
            if (distance >= 15) {
                pointRepository.save(newPoint);
                insert = true;
            }
        } else {
            pointRepository.save(newPoint);
            insert = true;
        }
        ResponseMessage responseMessage = new ResponseMessage(user_id, group_id, latitude, longitude, dateTime, insert);
        template.convertAndSend("/topic/" + groupID + "/locationChanged", responseMessage);
    }
}
