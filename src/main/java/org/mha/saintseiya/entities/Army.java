package org.mha.saintseiya.entities;

import java.io.Serializable;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "army")
public class Army extends PanacheMongoEntityBase implements Serializable {
    
    private static final long serialVersionUID = 546132133250L;

    @BsonId
    private String id;
    private String name;
    private List<Knight> members;
}
