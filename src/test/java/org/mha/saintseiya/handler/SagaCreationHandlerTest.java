package org.mha.saintseiya.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mha.saintseiya.entities.Saga;
import org.mha.saintseiya.handlers.SagaCreationHandler;
import org.mha.saintseiya.models.intefaces.CreationHandlerTest;
import org.mha.saintseiya.services.SagaService;
import org.mha.saintseiya.utils.Converter;
import org.mockito.Mockito;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.mongodb.MongoTestResource;

@QuarkusTest
@QuarkusTestResource(MongoTestResource.class)
public class SagaCreationHandlerTest implements CreationHandlerTest {

    @Inject
    SagaCreationHandler handler;

    @Inject
    SagaService sagaService;

    @BeforeEach
    public void setup(){

        sagaService = mock(SagaService.class);
        QuarkusMock.installMockForType(sagaService, SagaService.class);
    }

    @Override
    @Test
    public void testSuccess() {

        Saga saga = buildSaga();
        Map<String, Object> attributes = new LinkedHashMap<>();
        // attributes.put("username", "michel");        

        Mockito.when(sagaService.create(any())).thenReturn(saga);

        String body = Converter.objectoToJson(saga);

        APIGatewayProxyResponseEvent result = handler.handleRequest(buildEvent(body, attributes),  new MyContext());
        assertEquals(200, result.getStatusCode());
    }

    private Map<String, Object> buildEvent(String body, Map<String, Object> attributes){

        Map<String, Object> request = new LinkedHashMap<>();
        request.put("attributes", attributes);
        request.put("body", body);

        return request;
    }

    private Saga buildSaga() {

        return Saga.builder()
                .id("12345")
                .name("Classic")
                .initDate(LocalDate.of(1986, Month.OCTOBER, 11))
                .endDate(LocalDate.of(2002, Month.JUNE, 1))
                .author("Masami Kurumada").build();
    }

    @Override
    public void testRequiredFieldsIsNullError() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'testRequiredFieldsIsNullError'");
    }

    @Override
    public void testRequiredFieldsIdBlankError() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'testRequiredFieldsIdBlankError'");
    }

    @Override
    public void testMaxFieldLengthSuccess() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'testMaxFieldLengthSuccess'");
    }

    @Override
    public void testMaxFieldLengthExceededError() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'testMaxFieldLengthExceededError'");
    }

    @Override
    public void testDateInvalidFormat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'testDateInvalidFormat'");
    }
    
}
