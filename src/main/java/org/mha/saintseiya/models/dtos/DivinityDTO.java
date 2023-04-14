package org.mha.saintseiya.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DivinityDTO extends CharacterDTO {

    private String divinityName;
    private List<String> titles;
    private String kingdom;
    private ArmyDTO army;
}
