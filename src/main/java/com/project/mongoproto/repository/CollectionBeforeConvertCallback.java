package com.project.mongoproto.repository;

import com.project.mongoproto.model.Collection;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.stereotype.Component;

@Component
public class CollectionBeforeConvertCallback implements BeforeConvertCallback<Collection> {
    @Override
    public Collection onBeforeConvert(Collection entity, String collection) {
        if (collection.equalsIgnoreCase("collectionSchema")) {
            Long id = entity.getId();
            String key = entity.getKey();
            entity.setId(id);
            entity.setKey(key);
        }
        return entity;
    }

}
