package org.mha.saintseiya.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListResponse<T> {
    
    private Long size;
    private T elements;
}
