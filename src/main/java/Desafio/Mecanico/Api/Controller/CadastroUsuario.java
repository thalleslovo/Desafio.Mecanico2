package Desafio.Mecanico.Api.Controller;


import Desafio.Mecanico.Api.Domain.Cadastro.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroUsuario {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrousario(@RequestBody @Valid DadosCadastro dados , UriComponentsBuilder uriBuilder){

        var usuario = new Usuario(dados);
        repository.save(new Usuario(dados));

        var uri = uriBuilder.path("/cadastro/{id}").buildAndExpand(usuario.getId()).toUri();


        return ResponseEntity.created(uri).body(new DadosDetalhamentoSenha(usuario));


    }

    @GetMapping
    public  ResponseEntity <List<DadosListagemUsuario>> listar(){
        var List =  repository.findAll().stream().map(DadosListagemUsuario::new).toList();
        return ResponseEntity.ok(List);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarsenha(@RequestBody @Valid DadosAtualizacaoSenha dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoSenha(usuario));

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoSenha(usuario));
    }

}
