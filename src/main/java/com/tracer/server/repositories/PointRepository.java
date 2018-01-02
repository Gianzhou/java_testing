package com.tracer.server.repositories;

import com.tracer.server.models.database.Point;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PointRepository extends CrudRepository<Point, Long> {
    List<Point> findAllByGroupId(long group_id);
    List<Point> findAllByGroupIdAndGroupMemberId(long group_id, long group_member_id);
}
