package com.tracer.server.repositories;

import com.tracer.server.models.database.GroupMember;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupMemberRepository extends CrudRepository<GroupMember, Long> {
    List<GroupMember> findAllByUserId(long user_id);
    GroupMember findOneByUserIdAndGroupId(long user_id, long group_id);
}
