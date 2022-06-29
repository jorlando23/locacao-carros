package br.edu.ifms.locacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.locacao.entities.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
