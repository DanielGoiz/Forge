package br.unit.forgek.servico;


import br.unit.forgek.modelo.Mentor;
import br.unit.forgek.repositorio.MentorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServico {

    @Autowired
    private MentorRepositorio mentorRepositorio;

    public Mentor criarMentor(Mentor mentor) { return mentorRepositorio.save(mentor); }

    public List<Mentor> listarTodos() { return mentorRepositorio.findAll(); }

    public Optional<Mentor> buscarPorId(Long id) { return mentorRepositorio.findById(id); }

    public Mentor atualizarMentor(Long id, Mentor mentorDetalhes) {
        Mentor mentor = mentorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentor não encontrado para este id :: " + id));
        mentor.setNome(mentorDetalhes.getNome());
        mentor.setEmail(mentorDetalhes.getEmail());
        mentor.setEspecialidade(mentorDetalhes.getEspecialidade());
        mentor.setHorarioDisponivel(mentorDetalhes.getHorarioDisponivel());
        return mentorRepositorio.save(mentor);
    }

    public void deletarMentor(Long id) {
        Mentor mentor = mentorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentor não encontrado para este id :: " + id));
        mentorRepositorio.delete(mentor);

    }
}


