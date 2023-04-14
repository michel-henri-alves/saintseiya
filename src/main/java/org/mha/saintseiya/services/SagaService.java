package org.mha.saintseiya.services;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.mha.saintseiya.entities.Saga;
import org.mha.saintseiya.models.ListResponse;
import org.mha.saintseiya.models.intefaces.Service;
import org.mha.saintseiya.repositories.SagaRepository;
import org.mha.saintseiya.utils.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class SagaService implements Service<Saga> {

	private static final Logger logger = LoggerFactory.getLogger(SagaService.class);

	@Inject
	SagaRepository sagaRepository;

	public Saga create(Saga saga) {

		if (registerExist(saga) != null)
			throw new MyException("Duplicated register: " + saga.toString());
		sagaRepository.persist(saga);
		return saga;
	}

	// public ListResponse<List<Saga>> list(Map<String, Object> filter) {

	// List<Saga> sagas = sagaRepository.findAll().list();

	// ListResponse<List<Saga>> response = new ListResponse<>();
	// response.setSize(response.getSize());
	// response.setElements(sagas);

	// return response;
	// }

	public ListResponse<List<Saga>> list(Map<String, Object> filter) {

		List<Saga> sagas = sagaRepository
				.find(null)
				.page(Integer.parseInt(filter.get("page").toString()),
				Integer.parseInt(filter.get("size").toString()))
				.list();

		ListResponse<List<Saga>> response = new ListResponse<>();
		response.setSize(response.getSize());
		response.setElements(sagas);

		return response;
	}

	public Saga update(Saga objectToUpdate) {

		if (registerExist(objectToUpdate) != null)
			throw new MyException("Duplicated register: " + objectToUpdate.toString());
		Saga saga = getById(objectToUpdate.getId());

		// Saga oldSaga = Converter.objectToObject(saga, Saga.class);
		saga.setAuthor(objectToUpdate.getAuthor());
		saga.setEndDate(objectToUpdate.getEndDate());
		saga.setInitDate(objectToUpdate.getInitDate());
		saga.setName(objectToUpdate.getName());
		sagaRepository.update(saga);

		return saga;
	}

	public Saga delete(Saga saga) {

		if (registerExist(saga) == null)
			throw new MyException("Register not found: " + saga.toString());
		sagaRepository.delete(saga);
		return saga;
	}

	public Saga getById(String id) {
		return sagaRepository.findById(id);
	}

	private Saga registerExist(Saga saga) {
		// Saga existentRegister = sagaRepository.findByNameAndAuthor(saga.getName(),
		// saga.getAuthor());
		// if(existentRegister != null){
		// throw new MyException("Duplicated register: "+ saga.toString());
		// }
		return sagaRepository.findByNameAndAuthor(saga.getName(), saga.getAuthor());
	}
}
