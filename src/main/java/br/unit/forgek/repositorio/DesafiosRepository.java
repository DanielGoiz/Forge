package br.unit.forgek.repositorio;

import br.unit.forgek.modelo.DesafiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesafiosRepository extends JpaRepository<DesafiosEntity, Long> {
}