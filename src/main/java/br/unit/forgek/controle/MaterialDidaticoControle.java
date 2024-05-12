package br.unit.forgek.controle;

import br.unit.forgek.modelo.Empresa;
import br.unit.forgek.modelo.MaterialDidatico;
import br.unit.forgek.servico.EmpresaServico;
import br.unit.forgek.servico.MaterialDidaticoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/desafio/materialdidatico")
@Controller
public class MaterialDidaticoControle {

    @Autowired
    private MaterialDidaticoServico materialDidaticoServico;

    @PostMapping
    public ResponseEntity<MaterialDidatico> criarMaterial(@RequestBody MaterialDidatico materialDidatico) {
        MaterialDidatico novoMaterialDidatico = materialDidaticoServico.CriarMaterialDidatico(materialDidatico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMaterialDidatico);
    }

    @GetMapping
    public ResponseEntity<List<MaterialDidatico>> listarMateriais(){
        List<MaterialDidatico> materialDidatico = materialDidaticoServico.ListarMaterialDidatico();
        return ResponseEntity.ok(materialDidatico);
    }

    @GetMapping("/{ID}")
    public ResponseEntity<MaterialDidatico> BuscarMaterial(@PathVariable long ID){
        return materialDidaticoServico.buscarPorId(ID)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Material não encontrada"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDidatico> atualizarMaterial(@PathVariable Long id, @RequestBody MaterialDidatico materialDidaticoDetalhes) {
        MaterialDidatico materialDidatico = materialDidaticoServico.atualizarMaterialDidatico(id, materialDidaticoDetalhes);
        return ResponseEntity.ok(materialDidatico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMaterial(@PathVariable Long id) {
        materialDidaticoServico.deletarMaterialDidatico(id);
        return ResponseEntity.noContent().build();
    }
}
