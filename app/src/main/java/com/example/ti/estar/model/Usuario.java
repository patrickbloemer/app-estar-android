package com.example.ti.estar.model;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable{

    private String nome;
    private String email;
    private String senha;
    private String saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

}
