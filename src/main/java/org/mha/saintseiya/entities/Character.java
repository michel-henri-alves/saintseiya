package org.mha.saintseiya.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "character")
@BsonDiscriminator
public abstract class Character extends PanacheMongoEntityBase implements Serializable{

    @BsonId
    private String id;
    private String name;
    private int age;
    private LocalDateTime birth;
    private String nationality;
    private Set<Saga> sagas;
}