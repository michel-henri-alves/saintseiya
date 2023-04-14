package org.mha.saintseiya.models.dtos;

import org.mha.saintseiya.models.enums.Patent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArmorDTO{

    private String id;
    private String name;
    private Patent patent;
    private ArmyDTO army;
}