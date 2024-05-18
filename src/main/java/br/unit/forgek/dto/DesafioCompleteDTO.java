package br.com.unit.forge.dto;

public record DesafioCompleteDTO(
        Long idDesafios,
        String desafio,
        String solucao,
        String tecnologia,
        String materialDeEstudo,
        String video,
        String status,
        String avaliacao
) {
}
