package br.unit.forgek.repositorio;

import br.unit.forgek.modelo.HorarioDisponivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioDisponivelRepositorio extends JpaRepository<HorarioDisponivel, Long> {
    List<HorarioDisponivel> findByMentorId(Long mentorId);
}


