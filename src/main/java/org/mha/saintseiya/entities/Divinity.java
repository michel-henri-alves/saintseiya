package org.mha.saintseiya.entities;

import java.util.Set;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "divinity")
@BsonDiscriminator(key = "type", value = "divinity")
public class Divinity extends Character{
    
    private static final long serialVersionUID = 504186458639L;

    private String divinityName;
    private Set<String> titles;
    private String kingdom;
    private Army army;
}
