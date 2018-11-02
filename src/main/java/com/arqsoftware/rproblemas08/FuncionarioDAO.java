package com.arqsoftware.rproblemas08;



import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioDAO{

    @PostMapping("/funcionario")
    public Funcionario create (@RequestBody Funcionario funcionario){

        funcionario.setId(UUID.randomUUID());

        return funcionario;
    }

    @GetMapping("/funcionario")
    public List<Funcionario> read(){
        Funcionario f1 = new Funcionario("Joao", 25, (float)1500.00 );
        f1.setId(UUID.randomUUID());
        Funcionario f2 = new Funcionario("Maria", 30, (float)2000.00);
        f2.setId(UUID.randomUUID());

        return Stream.of(f1,f2).collect(Collectors.toList());
    }

    @PutMapping("/funcionario")
    public Funcionario update(@RequestBody Funcionario funcionario){

        funcionario.setId(UUID.randomUUID());
        funcionario.setNome(funcionario.getNome() + " -- Atualizado");
        
        return funcionario;
    }

    @DeleteMapping("/funcionario/{id}")
    public String delete(@PathVariable int id){

        return "Deletado";
    }
}