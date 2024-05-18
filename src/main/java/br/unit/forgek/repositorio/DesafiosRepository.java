package br.com.unit.forge.repository;

import br.com.unit.forge.entity.DesafiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesafiosRepository extends JpaRepository<DesafiosEntity, Long> {
}
