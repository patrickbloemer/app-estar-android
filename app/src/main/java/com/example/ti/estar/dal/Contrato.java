package com.example.ti.estar.dal;

import android.provider.BaseColumns;

public class Contrato {
    private Contrato() {}

    //Declarar todas as classes que vão virar tabela no banco
    public static class TabelaUsuario implements BaseColumns {
        public static final String NOME_TABELA = "tdUsuarios";
        public static final String NOME = "Nome";
        public static final String EMAIL = "Email";
        public static final String SENHA = "Senha";
        public static final String SALDO = "Saldo";
    }

    public static class TabelaVeiculo implements BaseColumns{
        public static final String NOME_TABELA = "tbVeiculos";
        public static final String MARCA = "Marca";
        public static final String MODELO = "Modelo";
        public static final String COR = "Cor";
        public static final String PLACA = "Placa";
        public static final String USUARIO_ID = "UsuarioID";
    }
}