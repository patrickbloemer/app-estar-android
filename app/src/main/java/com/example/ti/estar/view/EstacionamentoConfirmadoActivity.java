package com.example.ti.estar.view;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.ti.estar.R;
import com.example.ti.estar.dal.UsuarioDAO;
import com.example.ti.estar.model.Estacionamento;
import com.example.ti.estar.model.Usuario;


public class EstacionamentoConfirmadoActivity extends AppCompatActivity {
    private Estacionamento estacionamento = new Estacionamento();
    private TextView txtMarca, txtModelo, txtCor, txtPlaca,
            txtHoraChegada, txtMinutosChegada,
            txtHoraFinal, txtMinutosFinal, txtData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacionamento_confirmado);
        estacionamento = (Estacionamento) getIntent().getSerializableExtra("Estacionamento");

        Usuario u = UsuarioDAO.retornarUsuario();
        txtMarca = findViewById(R.id.txtMarca);
        txtModelo= findViewById(R.id.txtModelo);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtCor = findViewById(R.id.txtCor);
        txtHoraChegada = findViewById(R.id.txtHoraDaChegada);
        txtMinutosChegada = findViewById(R.id.txtMinutosDaChegada);
        txtHoraFinal = findViewById(R.id.txtHoraFinal);
        txtMinutosFinal = findViewById(R.id.txtMinutosFinal);
        txtData = findViewById(R.id.txtData);

        /*DETALHES O VEICULO*/
        txtMarca.setText(estacionamento.getVeiculo().getMarca().toString());
        txtModelo.setText(estacionamento.getVeiculo().getModelo().toString());
        txtCor.setText(estacionamento.getVeiculo().getCor().toString());
        txtPlaca.setText(estacionamento.getVeiculo().getPlaca().toString());

        /*DETALHES DO HORÁRIO*/
        txtHoraChegada.setText(String.valueOf(estacionamento.getHora()));
        txtMinutosChegada.setText(String.valueOf(estacionamento.getMinutos()));
        txtHoraFinal.setText(String.valueOf(estacionamento.getHora() + 1));
        txtMinutosFinal.setText(String.valueOf(estacionamento.getMinutos()));
        txtData.setText(String.valueOf(estacionamento.getData()));
    }


    public void btnVoltar(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}