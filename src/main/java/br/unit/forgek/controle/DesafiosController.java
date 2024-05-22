package br.unit.forgek.controle;

import br.unit.forgek.dto.*;
import br.unit.forgek.servico.DesafiosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/desafios")
public class DesafiosController {

    @Autowired
    private DesafiosService desafiosService;

    @PostMapping
    public ResponseEntity<DesafioCompletoDTO> criarDesafio(@Valid @RequestBody DesafioCompletoDTO desafioCompleteDTO) {
        return ResponseEntity.ok(desafiosService.criarDesafio(desafioCompleteDTO));
    }

    @GetMapping
    public ResponseEntity<List<DesafioCompletoDTO>> getAllDesafios() {
        return ResponseEntity.ok(desafiosService.getAllDesafios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesafioCompletoDTO> getDesafioById(@PathVariable Long id) {
        return ResponseEntity.ok(desafiosService.getDesafioById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDesafio(@PathVariable Long id) {
        desafiosService.excluirDesafio(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/desafio")
    public ResponseEntity<DesafioDTO> atualizarDesafio(@PathVariable Long id, @RequestBody DesafioDTO desafioDTO) {
        return ResponseEntity.ok(desafiosService.atualizarDesafio(id, desafioDTO));
    }

    @PutMapping("/{id}/solucao")
    public ResponseEntity<SolucaoDTO> atualizarSolucao(@PathVariable Long id, @RequestBody SolucaoDTO solucaoDTO) {
        return ResponseEntity.ok(desafiosService.atualizarSolucao(id, solucaoDTO));
    }

    @PutMapping("/{id}/tecnologia")
    public ResponseEntity<TecnologiaDTO> atualizarTecnologia(@PathVariable Long id, @RequestBody TecnologiaDTO tecnologiaDTO) {
        return ResponseEntity.ok(desafiosService.atualizarTecnologia(id, tecnologiaDTO));
    }

    @PutMapping("/{id}/materiais")
    public ResponseEntity<MaterialDeEstudoDTO> atualizarMateriaisDeEstudo(@PathVariable Long id, @RequestBody MaterialDeEstudoDTO materialDeEstudoDTO) {
        return ResponseEntity.ok(desafiosService.atualizarMaterialDeEstudo(id, materialDeEstudoDTO));
    }

    @PutMapping("/{id}/videos")
    public ResponseEntity<VideoDTO> atualizarVideos(@PathVariable Long id, @RequestBody VideoDTO videoDTO) {
        return ResponseEntity.ok(desafiosService.atualizarVideo(id, videoDTO));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<StatusDTO> atualizarStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        return ResponseEntity.ok(desafiosService.atualizarStatus(id, statusDTO));
    }

    @PutMapping("/{id}/avaliacao")
    public ResponseEntity<AvaliacaoDTO> atualizarAvaliacao(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        return ResponseEntity.ok(desafiosService.atualizarAvaliacao(id, avaliacaoDTO));
    }
}