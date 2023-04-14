package org.mha.saintseiya.handlers;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.mha.saintseiya.entities.Saga;
import org.mha.saintseiya.models.dtos.SagaDTO;
import org.mha.saintseiya.services.SagaService;
import org.mha.saintseiya.utils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

@Named("saga-creation")
public class SagaCreationHandler implements RequestHandler<Map<String, Object>, APIGatewayProxyResponseEvent> {

    private static final Logger logger = LoggerFactory.getLogger(SagaCreationHandler.class);

    @Inject
    SagaService sagaService;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(Map<String, Object> input, Context context) {
      
        try{
            Saga saga = Converter.objectToObject(input, Saga.class);
            SagaDTO sagaDTO = Converter.objectToObject(sagaService.create(saga), SagaDTO.class);
            
            APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
            response.setBody(Converter.objectoToJson(sagaDTO));
            
            return response;

        }catch (Exception e){

            return null;
        }
    }
    
}
