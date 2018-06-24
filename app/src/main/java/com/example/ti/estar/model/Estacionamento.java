package com.example.ti.estar.model;

import java.io.Serializable;
import java.util.Date;

public class Estacionamento implements Serializable{

    private String data;
    private int hora;
    private int minutos;
    private Usuario usuario;
    private Veiculo veiculo;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getHora() { return hora; }

    public void setHora(int hora) {this.hora = hora; }

    public int getMinutos() {return minutos; }

    public void setMinutos(int minutos) { this.minutos = minutos;}
}
