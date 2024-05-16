package br.unit.forgek.servico;


import br.unit.forgek.modelo.Representante;
import br.unit.forgek.repositorio.RepresentanteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepresentanteServico {


        @Autowired
        private RepresentanteRepositorio representanteRepositorio;

        public Representante criarRepresentante(Representante representante) {
            return representanteRepositorio.save(representante);
        }

        public List<Representante> listarTodas() {
            return representanteRepositorio.findAll();
        }

        public Optional<Representante> buscarPorId(Long id) {
            return representanteRepositorio.findById(id);
        }

        public Representante atualizarRepresentante(Long id, Representante representanteDetalhes) {
           Representante representante = representanteRepositorio.findById(id)
                    .orElseThrow(() -> new RuntimeException("Representante não encontrado para este id :: " + id));
            representante.setNome(representanteDetalhes.getNome());
            representante.setEmail(representanteDetalhes.getEmail());
            return representanteRepositorio.save(representante);
        }

        public void deletarRepresentante(Long id) {
            Representante representante = representanteRepositorio.findById(id)
                    .orElseThrow(() -> new RuntimeException("Representante não encontrado para este id :: " + id));
            representanteRepositorio.delete(representante);
        }
}

