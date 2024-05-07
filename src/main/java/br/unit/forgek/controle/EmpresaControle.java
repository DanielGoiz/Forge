package br.unit.forgek.controle;
import br.unit.forgek.modelo.Empresa;
import br.unit.forgek.servico.EmpresaServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/empresas") // Define a base path para todos os métodos deste controlador
@Controller
public class EmpresaControle {

    private final EmpresaServico empresaServico;

    public EmpresaControle(EmpresaServico empresaServico) {
        this.empresaServico = empresaServico;
    }

    @PostMapping // Mapeia requisições POST para /empresas
    public ResponseEntity<Empresa> criarEmpresa(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = empresaServico.criarEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa); // Retorna a empresa criada com status 201 Created
    }

    @GetMapping // Mapeia requisições GET para /empresas
    public ResponseEntity<List<Empresa>> listarTodasEmpresas() {
        List<Empresa> empresas = empresaServico.listarTodas();
        return ResponseEntity.ok(empresas); // Retorna a lista de empresas com status 200 OK
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /empresas/{id}
    public ResponseEntity<Empresa> buscarEmpresaPorId(@PathVariable Long id) {
        return empresaServico.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /empresas/{id}
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaDetalhes) {
        Empresa empresaAtualizada = empresaServico.atualizarEmpresa(id, empresaDetalhes);
        return ResponseEntity.ok(empresaAtualizada); // Retorna a empresa atualizada com status 200 OK
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /empresas/{id}
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        empresaServico.deletarEmpresa(id);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }
}