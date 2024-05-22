package br.unit.forgek.dto;

public record DesafioCompletoDTO(
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