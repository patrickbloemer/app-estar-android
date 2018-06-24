package com.example.ti.estar.dal;

import android.content.Intent;

import com.example.ti.estar.model.Estacionamento;
import com.example.ti.estar.model.Veiculo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EstacionamentoDAO {
    private static ArrayList<Veiculo> veiculosEstacionados = new ArrayList<>();
    private static ArrayList<Estacionamento> estacionamentos = new ArrayList<>();

    public static boolean estacionarVeiculo(Estacionamento e) {
        estacionamentos.add(e);
        return true;
    }

    public static ArrayList<Estacionamento> retornarListaEstacionamentos() {
        return (estacionamentos);
    }

    public static ArrayList<Estacionamento> retornarListaEstacionamentosAtivos() {
        ArrayList<Estacionamento> estacionamentosAtivos = new ArrayList<>();

        /*DETALHES DATA E HORA*/
        Calendar c = Calendar.getInstance();
        int hora = (c.get(Calendar.HOUR));
        int minutos = (c.get(Calendar.MINUTE));
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataDia = formatador.format(data);

        for (Estacionamento temp : estacionamentos) {

            if (temp.getHora() <= hora && temp.getMinutos() >= minutos){
                if(hora <= (temp.getHora() + 1) && minutos <= temp.getMinutos()){
                    estacionamentosAtivos.add(temp);
                }
            }
        }
        return estacionamentosAtivos;
    }
}
