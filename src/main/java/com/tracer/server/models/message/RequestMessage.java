package com.tracer.server.models.message;

import java.sql.Timestamp;

public class RequestMessage extends Message {
    public RequestMessage() {
    }

    public RequestMessage(long senderID, long groupID, double latitude, double longitude, long dateTime) {
        super(senderID, groupID, latitude, longitude, dateTime);
    }
}
