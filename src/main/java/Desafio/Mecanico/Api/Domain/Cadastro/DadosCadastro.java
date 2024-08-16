package Desafio.Mecanico.Api.Domain.Cadastro;

import Desafio.Mecanico.Api.Domain.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastro(

        @NotBlank
        String nome ,

        @NotBlank
        @Email
        String email ,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,5}")
        String senha ,

        @NotNull
        @Valid
        DadosEndereco endereco) {
}
