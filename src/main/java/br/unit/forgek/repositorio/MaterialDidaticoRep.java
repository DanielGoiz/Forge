package br.unit.forgek.repositorio;

import br.unit.forgek.modelo.Empresa;
import br.unit.forgek.modelo.MaterialDidatico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialDidaticoRep extends JpaRepository<MaterialDidatico, Long> {
}
