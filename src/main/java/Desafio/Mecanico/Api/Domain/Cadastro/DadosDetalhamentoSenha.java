package Desafio.Mecanico.Api.Domain.Cadastro;

import Desafio.Mecanico.Api.Domain.Endereco.Endereco;

public record DadosDetalhamentoSenha(Long id , String nome , String email, String senha ,String telefone, Endereco endereco) {


    public DadosDetalhamentoSenha(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTelefone(), usuario.getEndereco());
    }
}
