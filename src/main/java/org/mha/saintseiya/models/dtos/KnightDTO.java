package org.mha.saintseiya.models.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KnightDTO extends CharacterDTO {
    
    private ArmorDTO armor;
    private Set<String> attacks;
}
