package br.com.unit.forge.service;

import br.com.unit.forge.dto.*;
import br.com.unit.forge.entity.DesafiosEntity;
import br.com.unit.forge.repository.DesafiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesafiosService {

    @Autowired
    private DesafiosRepository desafiosRepository;

    public DesafioCompleteDTO createDesafio(DesafioCompleteDTO desafioCompleteDTO) {
        DesafiosEntity desafiosEntity = new DesafiosEntity();
        desafiosEntity.setDesafio(desafioCompleteDTO.desafio());
        desafiosEntity.setSolucao(desafioCompleteDTO.solucao());
        desafiosEntity.setTecnologia(desafioCompleteDTO.tecnologia());
        desafiosEntity.setMaterialDeEstudo(desafioCompleteDTO.materialDeEstudo());
        desafiosEntity.setVideo(desafioCompleteDTO.video());
        desafiosEntity.setStatus(desafioCompleteDTO.status());
        desafiosEntity.setAvaliacao(desafioCompleteDTO.avaliacao());
        DesafiosEntity desafiosEntitySaved = desafiosRepository.save(desafiosEntity);
        return new DesafioCompleteDTO(desafiosEntitySaved.getId(),
                desafiosEntitySaved.getDesafio(),
                desafiosEntitySaved.getSolucao(),
                desafiosEntitySaved.getTecnologia(),
                desafiosEntitySaved.getMaterialDeEstudo(),
                desafiosEntitySaved.getVideo(),
                desafiosEntitySaved.getStatus(),
                desafiosEntitySaved.getAvaliacao());
    }

    public List<DesafioCompleteDTO> getAllDesafios() {
        return desafiosRepository.findAll().stream()
                .map(desafiosEntity -> new DesafioCompleteDTO(desafiosEntity.getId(),
                        desafiosEntity.getDesafio(),
                        desafiosEntity.getSolucao(),
                        desafiosEntity.getTecnologia(),
                        desafiosEntity.getMaterialDeEstudo(),
                        desafiosEntity.getVideo(),
                        desafiosEntity.getStatus(),
                        desafiosEntity.getAvaliacao()))
                .collect(Collectors.toList());
    }

    public DesafioCompleteDTO getDesafioById(Long id) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(id).orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        return new DesafioCompleteDTO(desafiosEntity.getId(),
                desafiosEntity.getDesafio(),
                desafiosEntity.getSolucao(),
                desafiosEntity.getTecnologia(),
                desafiosEntity.getMaterialDeEstudo(),
                desafiosEntity.getVideo(),
                desafiosEntity.getStatus(),
                desafiosEntity.getAvaliacao());
    }

    public DesafioDTO updateDesafio(Long idDesafio, DesafioDTO desafioDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio).orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setDesafio(desafioDTO.desafio());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new DesafioDTO(updatedDesafio.getId(),updatedDesafio.getDesafio());
    }

    public SolucaoDTO updateSolucao(Long idDesafio, SolucaoDTO solucaoDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio).orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setSolucao(solucaoDTO.solucao());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new SolucaoDTO(updatedDesafio.getId(), updatedDesafio.getSolucao());
    }

    public TecnologiaDTO updateTecnologia(Long idDesafio, TecnologiaDTO tecnologiaDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio).orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setTecnologia(tecnologiaDTO.tecnologia());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new TecnologiaDTO(updatedDesafio.getId(), updatedDesafio.getTecnologia());
    }

    public MaterialDeEstudoDTO updateMaterialDeEstudo(Long idDesafio, MaterialDeEstudoDTO materialDeEstudoDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio).orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setMaterialDeEstudo(materialDeEstudoDTO.materalDeEstudo());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new MaterialDeEstudoDTO(updatedDesafio.getId(), updatedDesafio.getMaterialDeEstudo());
    }

    public VideoDTO updateVideo(Long idDesafio, VideoDTO videoDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio).orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setVideo(videoDTO.video());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new VideoDTO(updatedDesafio.getId(), updatedDesafio.getVideo());
    }

    public StatusDTO updateStatus(Long idDesafio, StatusDTO statusDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio).orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setStatus(statusDTO.status());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new StatusDTO(updatedDesafio.getId(), updatedDesafio.getStatus());
    }

    public AvaliacaoDTO updateAvaliacao(Long idDesafio, AvaliacaoDTO avaliacaoDTO) {
        DesafiosEntity desafiosEntity = desafiosRepository.findById(idDesafio).orElseThrow(() -> new RuntimeException("Desafio não encontrado"));
        desafiosEntity.setAvaliacao(avaliacaoDTO.avaliacao());
        DesafiosEntity updatedDesafio = desafiosRepository.save(desafiosEntity);
        return new AvaliacaoDTO(updatedDesafio.getId(), updatedDesafio.getAvaliacao());
    }

    public void deleteDesafio(Long idDesafio) {
        desafiosRepository.deleteById(idDesafio);
    }
}
