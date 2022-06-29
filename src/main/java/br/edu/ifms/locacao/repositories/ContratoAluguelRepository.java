package br.edu.ifms.locacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.locacao.entities.ContratoAluguel;

@Repository
public interface ContratoAluguelRepository extends JpaRepository<ContratoAluguel, Long> {

}
