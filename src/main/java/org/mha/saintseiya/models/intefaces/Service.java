package org.mha.saintseiya.models.intefaces;

import java.util.List;
import java.util.Map;

import org.mha.saintseiya.models.ListResponse;

public interface Service<T> {

    public Object create(T arg0);

    public ListResponse<List<T>> list(Map<String,Object> filter);
    
    public Object update(T arg0);
    
    public Object delete(T arg0);
    
    public Object getById(String id);
}
