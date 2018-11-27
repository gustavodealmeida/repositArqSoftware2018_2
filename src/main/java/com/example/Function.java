package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class Function {
    
    @FunctionName("createfuncionario")
    public Funcionario create(
        @HttpTrigger(
            name = "createfuncionariorest",
            methods = {HttpMethod.POST}, 
            route = "funcionario",
            authLevel = AuthorizationLevel.ANONYMOUS
        )
        Funcionario funcionario){

            return funcionario;
    }

    @FunctionName("readfuncionario")
    public List<Funcionario> read(
        @HttpTrigger(
            name = "readfuncionariorest",
            methods = {HttpMethod.GET},
            route = "funcionario",
            authLevel = AuthorizationLevel.ANONYMOUS
        ) 
        String x) {
            
            Funcionario f1 = new Funcionario(Long.valueOf(1),"Joao", 25, (double)1500.00 );
            Funcionario f2 = new Funcionario(Long.valueOf(2),"Maria", 30, (double)2000.00);

            return Stream.of(f1,f2).collect(Collectors.toList());
    }

    @FunctionName("updatefuncionario")
    public Funcionario update(
        @HttpTrigger(
            name ="updatefuncionariorest",
            methods = {HttpMethod.PUT},
            route = "funcionario"
        )
        Funcionario funcionario){

            funcionario.setNome(funcionario.getNome() + "-- Updated");

            return funcionario;
    }

    @FunctionName("deletefuncionario")
    public int Funcionario(
        @HttpTrigger(
            name = "deletefuncionariorest",
            methods = {HttpMethod.DELETE},
            route = "funcionario/{id}"
        ) Long id){

            return 200;
        }
    
}

class Funcionario{
    private Long id;
    private String nome;
    private int idade;
    private double salario;
    
    public Funcionario(Long id, String nome, int idade, double salario){
        this.setId(id);
        this.setNome(nome);
        this.setIdade(idade);
        this.setSalario(salario);
    }
    
    public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return this.idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSalario() {
		return this.salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
