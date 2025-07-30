package com.gabriel.myroute.entity;

public class Roteiro {
	private long id;
	private long id_user;
	private String nome;
	private String roteiro;

	
	
	
	
	public long getId() {
		return id;
	}

	public long getId_user() {
		return id_user;
	}
	public String getNome() {
		return nome;
	}
	public String getRoteiro() {
		return roteiro;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setRoteiro(String roteiro) {
		this.roteiro = roteiro;
	}
	
}
