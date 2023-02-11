package com.project.mongoproto.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import com.project.mongoproto.model.Unit;
import com.project.mongoproto.service.UnitService;
import com.telos.core.base.Id;
import com.telos.core.base.Name;
import com.telos.core.base.NameInLanguage;
import com.telos.core.base.Token;
import com.telos.core.quantity.UnitSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/save")
    public UnitSchema saveUnit() throws InvalidProtocolBufferException {
        Token token = Token.newBuilder().setId(Id.newBuilder().setU32(1113).setU64(1113).setKey("unitKeyToken-3").build()).build();
        UnitSchema unitSchema = UnitSchema.newBuilder().setUnitSchemaToken(token)
                .setName(Name.newBuilder().putName("weight", NameInLanguage.newBuilder()
                        .setCanonical("Canonical-weight").build()).build()).build();
        Unit unit = new Unit();
        unit.setUnitSchemaProto(unitSchema);
        return unitService.saveUnit(unit);
    }
}
