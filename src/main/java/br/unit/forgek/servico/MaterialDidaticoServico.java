package br.unit.forgek.servico;

import br.unit.forgek.modelo.MaterialDidatico;
import br.unit.forgek.repositorio.MaterialDidaticoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoServico {

    @Autowired
    private MaterialDidaticoRep MaterialDidaticoRep;

    public MaterialDidatico CriarMaterialDidatico(MaterialDidatico materialdidatico){
        return MaterialDidaticoRep.save(materialdidatico);
    }

    public List<MaterialDidatico> ListarMaterialDidatico(){
        return MaterialDidaticoRep.findAll();
    }

    public Optional<MaterialDidatico> buscarPorId(Long id) {
        return MaterialDidaticoRep.findById(id);
    }

    public MaterialDidatico atualizarMaterialDidatico(Long id, MaterialDidatico MaterialDidaticoDetalhes) {
        MaterialDidatico materialdidatico = MaterialDidaticoRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Material Didatico não encontrada para este id :: " + id));
        materialdidatico.SetVideo(MaterialDidaticoDetalhes.getVideo());
        materialdidatico.SetDescricao(MaterialDidaticoDetalhes.getDescricao());

        return MaterialDidaticoRep.save(materialdidatico);
    }

    public void deletarMaterialDidatico(Long id) {
        MaterialDidatico materialdidatico = MaterialDidaticoRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Material didatico não encontrada para este id :: " + id));
        MaterialDidaticoRep.delete(materialdidatico);
    }
}
