package org.mha.saintseiya.entities;

import java.time.LocalDate;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "saga")
public class Saga {

    private static final long serialVersionUID = 481043169186L;

    private String id;
    private String name;
    private LocalDate initDate;
    private LocalDate endDate;
    private String author;
}
