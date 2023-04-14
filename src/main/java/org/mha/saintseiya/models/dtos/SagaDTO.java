package org.mha.saintseiya.models.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SagaDTO{

    private String id;
    private String name;
    private LocalDateTime initDate;
    private LocalDateTime endDate;
    private String author;
}