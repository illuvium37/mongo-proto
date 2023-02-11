package com.project.mongoproto.repository;

import com.project.mongoproto.model.Unit;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.stereotype.Component;

@Component
public class UnitBeforeConvertCallback implements BeforeConvertCallback<Unit> {
    @Override
    public Unit onBeforeConvert(Unit entity, String collection) {
        if (collection.equalsIgnoreCase("unitSchema")) {
            Long id = entity.getUnitSchemaProto().getUnitSchemaToken().getId().getU64();
            String key = entity.getUnitSchemaProto().getUnitSchemaToken().getId().getKey();
            entity.setId(id);
            entity.setKey(key);
        }
        return entity;
    }

}
