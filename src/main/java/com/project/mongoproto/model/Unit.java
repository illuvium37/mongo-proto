package com.project.mongoproto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "unitSchema")
@Data
public class Unit {

    @Transient
    @JsonIgnore //for rest api
    private com.telos.core.quantity.UnitSchema unitSchemaProto;

    private byte[] proto;

    @Indexed
    private String key;

    @Id
    @Indexed
    private Long id;


}
