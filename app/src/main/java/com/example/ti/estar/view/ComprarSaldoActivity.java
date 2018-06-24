package com.example.ti.estar.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ti.estar.R;
import com.example.ti.estar.dal.UsuarioDAO;
import com.example.ti.estar.model.Usuario;

public class ComprarSaldoActivity extends AppCompatActivity {
    private EditText edtValorSaldo;
    private TextView txtNomeUsuario, txtSaldoAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_saldo);
        edtValorSaldo = findViewById(R.id.edtValorSaldo);

        txtNomeUsuario = findViewById(R.id.txtNomeUsuario);
        txtSaldoAtual = findViewById(R.id.txtSaldoAtual);

        Usuario u = UsuarioDAO.retornarUsuario();

        txtSaldoAtual.setText(u.getSaldo());
        txtNomeUsuario.setText(u.getNome());
    }


    public void btnComprarSaldo(View view) {
        if(edtValorSaldo.getText().toString().equals("")){
            Toast.makeText(this, "Favor Inserir um Valor", Toast.LENGTH_SHORT).show();
        }else {
            if(Integer.parseInt(edtValorSaldo.getText().toString()) > 50){
                Toast.makeText(this, "O Valor Máximo da Compra Não pode Ser Superior a R$50,00", Toast.LENGTH_SHORT).show();
            }else{
                Usuario u = UsuarioDAO.retornarUsuario();
                u.setSaldo(String.valueOf(Double.parseDouble(u.getSaldo().toString()) + Double.parseDouble(edtValorSaldo.getText().toString())));
                Intent i = new Intent(this, MainActivity.class);
                Toast.makeText(this, "Valor adquirido com sucesso!", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        }
    }
}