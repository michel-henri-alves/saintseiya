package org.mha.saintseiya.config;

import org.mha.saintseiya.repositories.SagaRepository;
import org.mha.saintseiya.services.SagaService;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(targets = {
    SagaService.class,
    SagaRepository.class
})

public class ReflectionConfig {
    
}
