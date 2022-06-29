package br.edu.ifms.locacao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.locacao.services.exceptions.DataBaseExcepetion;
import br.edu.ifms.locacao.services.exceptions.ResourceNotFoundExcepetion;
import br.edu.ifms.locacao.dto.CarroDTO;
import br.edu.ifms.locacao.entities.Carro;
import br.edu.ifms.locacao.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repository;
	
	@Transactional(readOnly = true)
	public List<CarroDTO> findAll() {
		List<Carro> list = repository.findAll();
		return list.stream().map(t -> new CarroDTO(t)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<CarroDTO> findAllPaged(PageRequest pageRequest) {
		Page<Carro> list = repository.findAll(pageRequest);
		return list.map(x -> new CarroDTO(x));
	}

	@Transactional(readOnly = true)
	public CarroDTO findById(Long id) {
		Optional<Carro> obj = repository.findById(id);
		Carro entity = obj.orElseThrow(() -> new ResourceNotFoundExcepetion("Carro não encontrado"));
		return new CarroDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<CarroDTO> findAllListId(List<Long> id) {
		List<Carro> list = repository.findAllById(id);
		return list.stream().map(t -> new CarroDTO(t)).collect(Collectors.toList());
	}

	@Transactional
	public CarroDTO insert(CarroDTO dto) {
		try {
			Carro entity = new Carro();
			entity.setData(dto);
			entity = repository.save(entity);
			return new CarroDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion("Não foi possivel cadastrar!");
		}

	}

	@Transactional
	public CarroDTO update(Long id, CarroDTO dto) {
		try {
			Carro entity = repository.getById(id);
			entity.setData(dto);
			entity = repository.save(entity);
			return new CarroDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion("O recurso com o ID = " + id + " não foi localizado");
		}
	}

	/*
	 * @Transactional public CarroDTO delete(Long id) { try { Carro entity =
	 * repository.getById(id); repository.delete(entity); return new
	 * CarroDTO(entity);
	 * 
	 * } catch (EntityNotFoundException e) { throw new
	 * ResourceNotFoundExcepetion("O recurso com o ID = "+id+" não foi localizado");
	 * }
	 * 
	 * }
	 */

	public void delete(Long id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExcepetion("O recurso com o ID = " + id + " não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseExcepetion("Não é posivel excluir o registro, pois o mesmo esta em uso");
		}

	}


}
