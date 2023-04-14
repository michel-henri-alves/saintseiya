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
@MongoEntity(collection = "knight")
@BsonDiscriminator(key = "type", value = "knight")
public class Knight extends Character{
    
    private static final long serialVersionUID = 950046443579L;

    private Armor armor;
    private Set<String> attacks;
}
