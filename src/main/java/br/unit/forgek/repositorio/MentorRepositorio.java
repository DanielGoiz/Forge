package br.unit.forgek.repositorio;

import br.unit.forgek.modelo.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepositorio extends JpaRepository<Mentor, Long>{
}