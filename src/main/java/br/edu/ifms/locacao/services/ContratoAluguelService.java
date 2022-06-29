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
import br.edu.ifms.locacao.dto.ContratoAluguelDTO;
import br.edu.ifms.locacao.entities.ContratoAluguel;
import br.edu.ifms.locacao.repositories.ContratoAluguelRepository;

@Service
public class ContratoAluguelService {
	
	@Autowired
	private ContratoAluguelRepository repository;

	@Transactional(readOnly = true)
	public List<ContratoAluguelDTO> findAll() {
		List<ContratoAluguel> list = repository.findAll();
		return list.stream().map(t -> new ContratoAluguelDTO(t)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<ContratoAluguelDTO> findAllPaged(PageRequest pageRequest) {
		Page<ContratoAluguel> list = repository.findAll(pageRequest);
		return list.map(x -> new ContratoAluguelDTO(x));
	}

	@Transactional(readOnly = true)
	public ContratoAluguelDTO findById(Long id) {
		Optional<ContratoAluguel> obj = repository.findById(id);
		ContratoAluguel entity = obj.orElseThrow(() -> new ResourceNotFoundExcepetion("Contrato de aluguel não encontrado"));
		return new ContratoAluguelDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<ContratoAluguelDTO> findAllListId(List<Long> id) {
		List<ContratoAluguel> list = repository.findAllById(id);
		return list.stream().map(t -> new ContratoAluguelDTO(t)).collect(Collectors.toList());
	}

	@Transactional
	public ContratoAluguelDTO insert(ContratoAluguelDTO dto) {
		try {
			ContratoAluguel entity = new ContratoAluguel();
			entity.setData(dto);
			entity = repository.save(entity);
			return new ContratoAluguelDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion("Não foi possivel cadastrar!");
		}

	}

	@Transactional
	public ContratoAluguelDTO update(Long id, ContratoAluguelDTO dto) {
		try {
			ContratoAluguel entity = repository.getById(id);
			entity.setData(dto);
			entity = repository.save(entity);
			return new ContratoAluguelDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion("O recurso com o ID = " + id + " não foi localizado");
		}
	}

	/*
	 * @Transactional public ContratoAluguelDTO delete(Long id) { try { ContratoAluguel entity =
	 * repository.getById(id); repository.delete(entity); return new
	 * ContratoAluguelDTO(entity);
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
