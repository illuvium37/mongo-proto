package com.project.mongoproto.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.project.mongoproto.model.Unit;
import com.project.mongoproto.repository.UnitRepository;
import com.telos.core.quantity.UnitSchema;
import org.springframework.stereotype.Service;

@Service
public class UnitService {
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }


    public UnitSchema saveUnit(Unit unit) throws InvalidProtocolBufferException {
        unit.setProto(unit.getUnitSchemaProto().toByteArray());
        Unit savedUnit = unitRepository.save(unit);
        return UnitSchema.parseFrom(savedUnit.getProto());
    }

}
