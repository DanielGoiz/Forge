package br.unit.forgek.controle;

import br.unit.forgek.modelo.Mentor;
import br.unit.forgek.servico.MentorServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/mentores") // Define a base path para todos os métodos deste controlador
@Controller
public class MentorControle {


    private final MentorServico mentorServico;

    public MentorControle(MentorServico mentorServico) {
        this.mentorServico = mentorServico;
    }

    @PostMapping // Mapeia requisições POST para /empresas
    public ResponseEntity<Mentor> criarMentor(@RequestBody Mentor mentor) {

        Mentor  novoMentor = mentorServico.criarMentor(mentor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMentor); // Retorna a empresa criada com status 201 Created
    }

    @GetMapping // Mapeia requisições GET para /empresas
    public ResponseEntity<List<Mentor>> listarTodosMentores() {
        List<Mentor> mentores = mentorServico.listarTodos();
        return ResponseEntity.ok(mentores); // Retorna a lista de empresas com status 200 OK
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /empresas/{id}
    public ResponseEntity<Mentor> buscarMentorPorId(@PathVariable Long id) {
        return mentorServico.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mentor não encontrado"));
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /empresas/{id}
    public ResponseEntity<Mentor> atualizarMentor(@PathVariable Long id, @RequestBody Mentor mentorDetalhes) {
        Mentor mentorAtualizado = mentorServico.atualizarMentor(id, mentorDetalhes);
        return ResponseEntity.ok(mentorAtualizado); // Retorna a empresa atualizada com status 200 OK
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /empresas/{id}
    public ResponseEntity<Void> deletarMentor(@PathVariable Long id) {
        mentorServico.deletarMentor(id);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }

}