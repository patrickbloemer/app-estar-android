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
import android.widget.Toast;

import com.example.ti.estar.R;
import com.example.ti.estar.dal.EstacionamentoDAO;
import com.example.ti.estar.model.Estacionamento;
import com.example.ti.estar.model.Veiculo;
import com.example.ti.estar.view.EstacionarActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayAdapterVeiculos extends ArrayAdapter<Veiculo> {

    private TextView txtMarca, txtModelo, txtPlaca, txtCor;
    private ArrayList<Veiculo> veiculos;
    private Context context;

    public ArrayAdapterVeiculos(Context context, ArrayList<Veiculo> veiculos) {
        super(context, 0, veiculos);
        this.veiculos = veiculos;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Veiculo veiculo = veiculos.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.activity_item_list_veiculo_layout, null);
        }

        txtMarca = (TextView) convertView.findViewById(R.id.txtMarca);
        txtModelo = (TextView) convertView.findViewById(R.id.txtModelo);
        txtCor = (TextView) convertView.findViewById(R.id.txtCor);
        txtPlaca = (TextView) convertView.findViewById(R.id.txtPlaca);


        txtMarca.setText(veiculo.getMarca().toString());
        txtModelo.setText(veiculo.getModelo().toString());
        txtCor.setText(veiculo.getCor().toString());
        txtPlaca.setText(veiculo.getPlaca().toString());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Estacionamento> estacionamentos = EstacionamentoDAO.retornarListaEstacionamentosAtivos();
                if(estacionamentos.isEmpty()){
                    Intent intent = new Intent(context, EstacionarActivity.class);
                    intent.putExtra("Veiculo", veiculo);
                    context.startActivity(intent);
                }else{
                    for (Estacionamento temp : estacionamentos){
                        if(!temp.getVeiculo().getPlaca().toString().equals(veiculo.getPlaca().toString())){
                            Intent intent = new Intent(context, EstacionarActivity.class);
                            intent.putExtra("Veiculo", veiculo);
                            context.startActivity(intent);
                        }
                    }
                    Toast.makeText(context, "Este Veículo Já Está Estacionado. Aguarde!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return convertView;
    }
}
