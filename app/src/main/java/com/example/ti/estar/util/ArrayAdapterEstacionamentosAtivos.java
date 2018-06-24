package com.example.ti.estar.util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ti.estar.R;
import com.example.ti.estar.model.Estacionamento;
import com.example.ti.estar.view.EstacionamentoConfirmadoActivity;


import java.util.ArrayList;

public class ArrayAdapterEstacionamentosAtivos extends ArrayAdapter<Estacionamento> {

    private TextView txtMarca, txtPlaca, txtHorarioDaChegada, txtHorarioFinal;
    private ArrayList<Estacionamento> estacionamentos;
    private Context context;

    public ArrayAdapterEstacionamentosAtivos(Context context, ArrayList<Estacionamento> estacionamentos) {
        super(context, 0, estacionamentos);
        this.estacionamentos = estacionamentos;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Estacionamento estacionamento = estacionamentos.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.activity_item_list_estacionamento_layout, null);
        }

        txtMarca = (TextView) convertView.findViewById(R.id.txtMarca);
        txtPlaca = (TextView) convertView.findViewById(R.id.txtPlaca);
        txtHorarioDaChegada = convertView.findViewById(R.id.txtHoraDaChegada);
        txtHorarioFinal = convertView.findViewById(R.id.txtHorarioFinal);


        txtMarca.setText(estacionamento.getVeiculo().getMarca().toString());
        txtPlaca.setText(estacionamento.getVeiculo().getPlaca().toString());
        txtHorarioDaChegada.setText(String.valueOf(estacionamento.getHora() + ":" + estacionamento.getMinutos()));
        txtHorarioFinal.setText(String.valueOf((estacionamento.getHora() + 1) + ":" + estacionamento.getMinutos()));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EstacionamentoConfirmadoActivity.class);
                intent.putExtra("Estacionamento", estacionamento);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}