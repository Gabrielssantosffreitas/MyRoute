package com.gabriel.myroute.entity;

public class User {
    private long id;
    private String nome;
    private String email;
    private String senha;
    private  String telefone;

    public User(long id, String nome, String email, String tell, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = tell;
    }
    public User(String nome, String email, String tell, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = tell;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getTell() {return telefone;}

    public void setTell(String tell) {this.telefone = tell;}

    public String getSenha() { return this.senha;}
}
