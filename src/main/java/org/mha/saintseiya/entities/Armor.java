package org.mha.saintseiya.entities;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.mha.saintseiya.models.enums.Patent;

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
@MongoEntity(collection = "armor")
public class Armor extends PanacheMongoEntityBase implements Serializable {

    private static final long serialVersionUID = 963073648305L;

    @BsonId
    private String id;
    private String name;
    private Patent patent;
    private Army army;
}