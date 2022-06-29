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
import br.edu.ifms.locacao.dto.ClienteDTO;
import br.edu.ifms.locacao.entities.Cliente;
import br.edu.ifms.locacao.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Cliente> list = repository.findAll();
		return list.stream().map(t -> new ClienteDTO(t)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAllPaged(PageRequest pageRequest) {
		Page<Cliente> list = repository.findAll(pageRequest);
		return list.map(x -> new ClienteDTO(x));
	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundExcepetion("Cliente não encontrado"));
		return new ClienteDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAllListId(List<Long> id) {
		List<Cliente> list = repository.findAllById(id);
		return list.stream().map(t -> new ClienteDTO(t)).collect(Collectors.toList());
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		try {
			Cliente entity = new Cliente();
			entity.setData(dto);
			entity = repository.save(entity);
			return new ClienteDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion("Não foi possivel cadastrar!");
		}

	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			Cliente entity = repository.getById(id);
			entity.setData(dto);
			entity = repository.save(entity);
			return new ClienteDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion("O recurso com o ID = " + id + " não foi localizado");
		}
	}

	/*
	 * @Transactional public ClienteDTO delete(Long id) { try { Cliente entity =
	 * repository.getById(id); repository.delete(entity); return new
	 * ClienteDTO(entity);
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
