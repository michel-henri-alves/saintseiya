package org.mha.saintseiya.models.dtos;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO{

    private String id;
    private String name;
    private int age;
    private LocalDateTime birth;
    private String nationality;
    private Set<SagaDTO> sagas;
}