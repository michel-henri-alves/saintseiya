package org.mha.saintseiya.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArmyDTO {
    
    private String id;
    private String name;
    private List<KnightDTO> members;

    
}
