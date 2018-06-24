package com.example.ti.estar.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ti.estar.R;
import com.example.ti.estar.dal.EstacionamentoDAO;
import com.example.ti.estar.dal.UsuarioDAO;
import com.example.ti.estar.dal.VeiculoDAO;
import com.example.ti.estar.model.Usuario;
import com.example.ti.estar.util.ArrayAdapterVeiculos;
import com.example.ti.estar.util.ArrayAdapterEstacionamentosAtivos;


public class MainActivity extends AppCompatActivity {

    private TextView txtSaldo, txtNomeUsuario;
    private Button btnCad;
    private ListView listViewVeiculos, listViewVeiculosEstacionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSaldo = findViewById(R.id.txtSaldo);
        btnCad = findViewById(R.id.btnCad);
        listViewVeiculos = findViewById(R.id.listViewVeiculos);
        listViewVeiculos = (ListView) findViewById(R.id.listViewVeiculos);
        txtNomeUsuario = findViewById(R.id.txtUsuarioNome);
        listViewVeiculosEstacionados = findViewById(R.id.listViewVeiculosEstacionados);
        listViewVeiculosEstacionados = (ListView) findViewById(R.id.listViewVeiculosEstacionados);


        ArrayAdapterEstacionamentosAtivos arrayAdapterEstacionamentosAtivos =
                new ArrayAdapterEstacionamentosAtivos(this,
                        EstacionamentoDAO.retornarListaEstacionamentosAtivos());
        listViewVeiculosEstacionados.setAdapter(arrayAdapterEstacionamentosAtivos);



        ArrayAdapterVeiculos arrayAdapterVeiculos =
                new ArrayAdapterVeiculos(this,
                        VeiculoDAO.retornarVeiculosDoUsuarioLogado());

        listViewVeiculos.setAdapter(arrayAdapterVeiculos);

        Usuario user = new Usuario();
        user = UsuarioDAO.retornarUsuario();
        txtNomeUsuario.setText(user.getNome().toString());
        txtSaldo.setText(user.getSaldo());
    }

    public void btnCadVeiculo(View view) {
        Intent a = new Intent(this, CadVeiculoActivity.class);
        startActivity(a);
    }

    public void btnLoggout(View view) {
        UsuarioDAO.deslogarUsuario();
        Intent a = new Intent(this, LoginActivity.class);
        startActivity(a);
    }

    public void btnComprarSaldo(View view) {
        Intent intent = new Intent(this, ComprarSaldoActivity.class);
        startActivity(intent);
    }
}