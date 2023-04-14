package org.mha.saintseiya.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.mha.saintseiya.entities.Saga;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;

@ApplicationScoped
public class SagaRepository implements PanacheMongoRepositoryBase<Saga, String>{
    
    public Saga findByName(String name){
        return find("name", name).firstResult();
    }

    public Saga findById(String id){
        return find("_id", id).firstResult();
    }

    public Saga findByNameAndAuthor(String name, String author){
        
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("author", author);
        return find("name = :name and author = :author", params).firstResult();
    }
}
