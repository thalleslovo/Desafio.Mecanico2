package Desafio.Mecanico.Api.Domain.Cadastro;

import Desafio.Mecanico.Api.Domain.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nome;
    private  String  email;
    private  String telefone;
    private  String senha;

    @Embedded
    private Endereco endereco;

    public Usuario(DadosCadastro dados) {
       this.nome = dados.nome();
       this.email= dados.email();
       this.senha = dados.senha();
       this.telefone= dados.telefone();
       this.endereco = new Endereco(dados.endereco());

    }

    public void atualizarInformacoes(DadosAtualizacaoSenha dados) {
      if (dados.senha() != null){
          this.senha = dados.senha();
      }
    }
}
