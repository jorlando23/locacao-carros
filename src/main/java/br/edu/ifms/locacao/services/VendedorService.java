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
import br.edu.ifms.locacao.dto.VendedorDTO;
import br.edu.ifms.locacao.entities.Vendedor;
import br.edu.ifms.locacao.repositories.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repository;

	@Transactional(readOnly = true)
	public List<VendedorDTO> findAll() {
		List<Vendedor> list = repository.findAll();
		return list.stream().map(t -> new VendedorDTO(t)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<VendedorDTO> findAllPaged(PageRequest pageRequest) {
		Page<Vendedor> list = repository.findAll(pageRequest);
		return list.map(x -> new VendedorDTO(x));
	}

	@Transactional(readOnly = true)
	public VendedorDTO findById(Long id) {
		Optional<Vendedor> obj = repository.findById(id);
		Vendedor entity = obj.orElseThrow(() -> new ResourceNotFoundExcepetion("Vendedor não encontrado"));
		return new VendedorDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<VendedorDTO> findAllListId(List<Long> id) {
		List<Vendedor> list = repository.findAllById(id);
		return list.stream().map(t -> new VendedorDTO(t)).collect(Collectors.toList());
	}

	@Transactional
	public VendedorDTO insert(VendedorDTO dto) {
		try {
			Vendedor entity = new Vendedor();
			entity.setData(dto);
			entity = repository.save(entity);
			return new VendedorDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion("Não foi possivel cadastrar!");
		}

	}

	@Transactional
	public VendedorDTO update(Long id, VendedorDTO dto) {
		try {
			Vendedor entity = repository.getById(id);    	
    		entity.setCodigo(dto.getCodigo());		
    		entity.setNome(dto.getNome());
    		entity.setEmail(dto.getEmail());
    		entity.setTelefone(dto.getTelefone());
		 	entity = repository.save(entity);		
		 	return new VendedorDTO(entity);
    	} catch (EntityNotFoundException e) {
    		throw new ResourceNotFoundExcepetion("O Vendedor com o ID = "+id+" não foi localizado");    		
    	}
	}

	/*
	 * @Transactional public VendedorDTO delete(Long id) { try { Vendedor entity =
	 * repository.getById(id); repository.delete(entity); return new
	 * VendedorDTO(entity);
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
