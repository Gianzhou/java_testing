package com.tracer.server.repositories;

import com.tracer.server.models.database.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {}
