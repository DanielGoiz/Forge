package br.com.unit.forge.controller;

import br.com.unit.forge.dto.*;
import br.com.unit.forge.service.DesafiosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desafios")
public class DesafiosController {

    @Autowired
    private DesafiosService desafiosService;

    @PostMapping
    public ResponseEntity<DesafioCompleteDTO> createDesafio(@Valid @RequestBody DesafioCompleteDTO desafioCompleteDTO) {
        return ResponseEntity.ok(desafiosService.createDesafio(desafioCompleteDTO));
    }

    @GetMapping
    public ResponseEntity<List<DesafioCompleteDTO>> getAllDesafios() {
        return ResponseEntity.ok(desafiosService.getAllDesafios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesafioCompleteDTO> getDesafioById(@PathVariable Long id) {
        return ResponseEntity.ok(desafiosService.getDesafioById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesafio(@PathVariable Long id) {
        desafiosService.deleteDesafio(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/desafio")
    public ResponseEntity<DesafioDTO> updateDesafio(@PathVariable Long id, @RequestBody DesafioDTO desafioDTO) {
        return ResponseEntity.ok(desafiosService.updateDesafio(id, desafioDTO));
    }

    @PutMapping("/{id}/solucao")
    public ResponseEntity<SolucaoDTO> updateSolucao(@PathVariable Long id, @RequestBody SolucaoDTO solucaoDTO) {
        return ResponseEntity.ok(desafiosService.updateSolucao(id, solucaoDTO));
    }

    @PutMapping("/{id}/tecnologia")
    public ResponseEntity<TecnologiaDTO> updateTecnologia(@PathVariable Long id, @RequestBody TecnologiaDTO tecnologiaDTO) {
        return ResponseEntity.ok(desafiosService.updateTecnologia(id, tecnologiaDTO));
    }

    @PutMapping("/{id}/materiais")
    public ResponseEntity<MaterialDeEstudoDTO> updateMateriaisDeEstudo(@PathVariable Long id, @RequestBody MaterialDeEstudoDTO materialDeEstudoDTO) {
        return ResponseEntity.ok(desafiosService.updateMaterialDeEstudo(id, materialDeEstudoDTO));
    }

    @PutMapping("/{id}/videos")
    public ResponseEntity<VideoDTO> updateVideos(@PathVariable Long id, @RequestBody VideoDTO videoDTO) {
        return ResponseEntity.ok(desafiosService.updateVideo(id, videoDTO));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<StatusDTO> updateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        return ResponseEntity.ok(desafiosService.updateStatus(id, statusDTO));
    }

    @PutMapping("/{id}avaliacao")
    public ResponseEntity<AvaliacaoDTO> updateAvaliacao(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        return ResponseEntity.ok(desafiosService.updateAvaliacao(id, avaliacaoDTO));
    }
}
