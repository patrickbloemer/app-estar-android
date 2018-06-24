package com.example.ti.estar.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ti.estar.R;
import com.example.ti.estar.dal.VeiculoDAO;
import com.example.ti.estar.model.Veiculo;

public class CadVeiculoActivity extends AppCompatActivity {

    private EditText edtMarca, edtPlaca, edtModelo, edtCor;
    private Button btnCadVeiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_veiculo);
        edtMarca= findViewById(R.id.edtMarca);
        edtCor = findViewById(R.id.edtCor);
        edtModelo = findViewById(R.id.edtModelo);
        edtPlaca = findViewById(R.id.edtPlaca);
        btnCadVeiculo = findViewById(R.id.btnCadVeiculo);
    }
    public void btnCadVeiculo(View view) {

        Veiculo v = new Veiculo();

        v.setCor(edtCor.getText().toString());
        v.setMarca(edtMarca.getText().toString());
        v.setModelo(edtModelo.getText().toString());
        v.setPlaca(edtPlaca.getText().toString());

        if(VeiculoDAO.cadastrarVeiculo(v)){
            Toast.makeText(this, "Cadastro efetivado com sucesso.", Toast.LENGTH_SHORT).show();
        }

        //Após cadastrar o carro, redireciona para a tela principal do cliente.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

