package Desafio.Mecanico.Api.Domain.Cadastro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoSenha(
        @NotNull
        Long id ,

        @NotBlank
        String senha) {
}
