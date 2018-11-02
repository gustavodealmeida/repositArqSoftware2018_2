package com.arqsoftware.rproblemas08; 

import java.util.UUID;

public class Funcionario {
    private UUID id;
    private String nome;
    private int idade;
    private float salario;

	public Funcionario(String nome, int idade, float salario) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
    
    
    
}
