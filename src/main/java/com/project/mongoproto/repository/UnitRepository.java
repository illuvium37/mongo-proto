package com.project.mongoproto.repository;

import com.project.mongoproto.model.Unit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends MongoRepository<Unit,Long> {
}
