package org.mha.saintseiya.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mha.saintseiya.entities.Saga;
import org.mha.saintseiya.models.ListResponse;
import org.mha.saintseiya.models.intefaces.ServiceTest;
import org.mha.saintseiya.repositories.SagaRepository;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class SagaServiceTest implements ServiceTest {

    @Inject
    SagaService sagaService;

    @Inject
    SagaRepository sagaRepository;

    @BeforeEach
    void setup(){
        sagaRepository.deleteAll();
    }

    @Override
    @Test
    public void testCreationSuccess() {

        Saga saga = buildSaga();
        Saga result = sagaService.create(saga);

        assertEquals(saga.getId(), result.getId());
        assertEquals(saga.getName(), result.getName());
        assertEquals(saga.getEndDate(), result.getEndDate());
        assertEquals(saga.getInitDate(), result.getInitDate());
        assertEquals(saga.getAuthor(), result.getAuthor());
    }

    @Override
    @Test
    public void testCreationDuplicatedError() {

        try {

            Saga saga = buildSaga();
            sagaService.create(saga);
            sagaService.create(saga);

        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Duplicated register"));
        }
    }

    @Override
    @Test
    public void testListingSuccess() {

        Saga saga = buildSaga();
        sagaService.create(saga);

        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("limit", 10);

        ListResponse<List<Saga>> list = sagaService.list(params);
        assertEquals(1,list.getElements().size());
        assertEquals(saga.getAuthor(), list.getElements().get(0).getAuthor());
        assertEquals(saga.getEndDate(), list.getElements().get(0).getEndDate());
        assertEquals(saga.getId(), list.getElements().get(0).getId());
        assertEquals(saga.getInitDate(), list.getElements().get(0).getInitDate());
        assertEquals(saga.getName(), list.getElements().get(0).getName());
    }

    @Test
    public void testListingFilteredSuccess() {

        Saga saga1 = buildSaga();
        sagaService.create(saga1);

        Saga saga2 = buildSaga();
        saga2.setName("Asgard");
        sagaService.create(saga2);

        Map<String, Object> params = new HashMap<>();
        params.put("name", saga2.getName());
        params.put("page", 1);
        params.put("limit", 10);

        ListResponse<List<Saga>> list = sagaService.list(params);
        assertEquals(1,list.getElements().size());
        assertEquals(saga2.getAuthor(), list.getElements().get(0).getAuthor());
        assertEquals(saga2.getEndDate(), list.getElements().get(0).getEndDate());
        assertEquals(saga2.getId(), list.getElements().get(0).getId());
        assertEquals(saga2.getInitDate(), list.getElements().get(0).getInitDate());
        assertEquals(saga2.getName(), list.getElements().get(0).getName());
    }

    @Override
    @Test
    public void testGetByIdSuccess() {

        Saga saga = buildSaga();
        sagaService.create(saga);

        Saga result = sagaService.getById(saga.getId());
        assertEquals(saga.getId(), result.getId());
        assertEquals(saga.getAuthor(), result.getAuthor());
        assertEquals(saga.getEndDate(), result.getEndDate());
        assertEquals(saga.getInitDate(), result.getInitDate());
        assertEquals(saga.getName(), result.getName());
    }

    @Override
    @Test
    public void testGetByIdElementNotFound() {

        assertEquals(sagaService.getById(buildSaga().getId()), null);
    }

    @Override
    @Test
    public void testUpdateSuccess() {

        Saga original = buildSaga();
        sagaService.create(original);
        Saga result0 = sagaRepository.findByNameAndAuthor(original.getName(), original.getAuthor());
        assertEquals(original.getName(), result0.getName());
        assertEquals(original.getAuthor(), result0.getAuthor());

        Saga updated = buildSaga();
        updated.setName("Turma da Monica");
        updated.setAuthor("Mauricio de Souza");
        sagaService.update(updated);

        Saga result1 = sagaRepository.findByNameAndAuthor(updated.getName(), updated.getAuthor());
        assertEquals("Turma da Monica", result1.getName());
        assertEquals("Mauricio de Souza", result1.getAuthor());
    }

    @Override
    @Test
    public void testUpdateDuplicatedError() {

        try {

            sagaRepository = mock(SagaRepository.class);
            QuarkusMock.installMockForType(sagaRepository, SagaRepository.class);

            Saga originalRegister = buildSaga();
            Saga updatedRegister = buildSaga();
            updatedRegister.setName("Turma da Monica");
            updatedRegister.setAuthor("Mauricio de Souza");

            when(sagaRepository.findById(any())).thenReturn(originalRegister);
            when(sagaRepository.findByNameAndAuthor(any(), any())).thenReturn(new Saga());
            sagaService.update(updatedRegister);

        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Duplicated register"));
        }
    }

    @Override
    @Test
    public void testDeletionSucess() {

        Saga saga = buildSaga();

        sagaService.create(saga);
        Saga response0 = sagaRepository.findByNameAndAuthor(saga.getName(), saga.getAuthor());
        assertEquals(saga.getName(), response0.getName());

        sagaService.delete(saga);
        Saga response1 = sagaRepository.findByNameAndAuthor(saga.getName(), saga.getAuthor());
        assertEquals(null, response1);
    }

    @Override
    @Test
    public void testDeletionElementNotFoundError() {

        try {
            sagaService.delete(buildSaga());

        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Register not found"));
        }
    }

    private Saga buildSaga() {

        return Saga.builder()
                .id("12345")
                .name("Classic")
                .initDate(LocalDate.of(1986, Month.OCTOBER, 11))
                .endDate(LocalDate.of(2002, Month.JUNE, 1))
                .author("Masami Kurumada").build();
    }
}
