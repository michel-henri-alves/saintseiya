package org.mha.saintseiya.utils;

import javax.enterprise.context.ApplicationScoped;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ApplicationScoped
public class Converter<T> {

    
    private static ObjectMapper getObjectMapper(){
        
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new JodaModule());

        return objectMapper;
    }

    public static <T> T objectToObject(Object from, Class<T> to){
        return getObjectMapper().convertValue(from, to);
    }

    public static <T> String objectoToJson(T from){
        try {
            return getObjectMapper().writeValueAsString(from);
        } catch (JsonProcessingException e) {
            //TODO: CRIAR O TRATAMENTO DE ERROS CENTRALIZADO
            //throw new Exception(e);
            return null;
        }
    }
}
