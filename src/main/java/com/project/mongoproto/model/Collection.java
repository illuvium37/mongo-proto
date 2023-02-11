package com.project.mongoproto.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "collectionSchema")
@Data
public class Collection {
    @Transient
    private com.telos.core.type.Collection collectionProto;

    private byte[] proto;

    @Indexed
    private String key;

    @Id
    @Indexed
    private Long id;
}
