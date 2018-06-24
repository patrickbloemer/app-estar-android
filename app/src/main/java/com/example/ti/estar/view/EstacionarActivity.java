package com.example.ti.estar.view;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ti.estar.R;
import com.example.ti.estar.dal.EstacionamentoDAO;
import com.example.ti.estar.dal.UsuarioDAO;
import com.example.ti.estar.model.Estacionamento;
import com.example.ti.estar.model.Usuario;
import com.example.ti.estar.model.Veiculo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EstacionarActivity extends AppCompatActivity {
    private Veiculo veiculo;
    private TextView txtMarca, txtModelo, txtCor, txtPlaca,
            txtSaldoAtual, txtValorASerDebitado,
            txtNovoSaldo, txtHoraChegada, txtMinutosChegada,
            txtHoraFinal, txtMinutosFinal, txtData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacionar);

        Usuario u = UsuarioDAO.retornarUsuario();

        if(Double.parseDouble(u.getSaldo()) < 2){
            Toast.makeText(this, "Saldo Insuficiente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        txtMarca = findViewById(R.id.txtMarca);
        txtModelo= findViewById(R.id.txtModelo);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtCor = findViewById(R.id.txtCor);
        txtSaldoAtual = findViewById(R.id.txtSaldoAtual);
        txtValorASerDebitado = findViewById(R.id.txtValorASerDebitado);
        txtNovoSaldo= findViewById(R.id.txtNovoSaldo);
        txtHoraChegada = findViewById(R.id.txtHoraDaChegada);
        txtMinutosChegada = findViewById(R.id.txtMinutosDaChegada);
        txtHoraFinal = findViewById(R.id.txtHoraFinal);
        txtMinutosFinal = findViewById(R.id.txtMinutosFinal);
        txtData = findViewById(R.id.txtData);

        /*DETALHES O VEICULO*/
        veiculo = (Veiculo) getIntent().getSerializableExtra("Veiculo");
        txtMarca.setText(veiculo.getMarca().toString());
        txtModelo.setText(veiculo.getModelo().toString());
        txtCor.setText(veiculo.getCor().toString());
        txtPlaca.setText(veiculo.getPlaca().toString());

        /*DETALHES DO SALDO*/
        txtSaldoAtual.setText(u.getSaldo());
        txtValorASerDebitado.setText("2");
        txtNovoSaldo.setText(String.valueOf(Double.parseDouble(u.getSaldo().toString()) - 2));

        /*DETALHES DO HORÁRIO*/
        Calendar c = Calendar.getInstance();

        int hora = (c.get(Calendar.HOUR));
        txtHoraChegada.setText(String.valueOf(hora));

        int minutos = (c.get(Calendar.MINUTE));
        txtMinutosChegada.setText(String.valueOf(minutos));

        txtHoraFinal.setText(String.valueOf(hora + 1));
        txtMinutosFinal.setText(String.valueOf(minutos));

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        String dataDia = formatador.format(data);
        txtData.setText(dataDia);
    }


    public void btnConfirmarEstacionamento(View view) {
        Toast.makeText(this, "Veículo Estacionado", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, MainActivity.class);



        Estacionamento e = new Estacionamento();
        Veiculo v = new Veiculo();
        v = (Veiculo) getIntent().getSerializableExtra("Veiculo");
        Usuario u = new Usuario();
        u = UsuarioDAO.retornarUsuario();
        e.setVeiculo(v);
        e.setUsuario(u);
        e.setData(txtData.getText().toString());
        e.setHora(Integer.parseInt(txtHoraChegada.getText().toString()));
        e.setMinutos(Integer.parseInt(txtMinutosChegada.getText().toString()));

        EstacionamentoDAO.estacionarVeiculo(e);
        u.setSaldo(String.valueOf(Double.parseDouble(u.getSaldo()) - 2));
        startActivity(i);
    }
}