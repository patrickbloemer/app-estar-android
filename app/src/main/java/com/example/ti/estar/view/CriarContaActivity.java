package com.example.ti.estar.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ti.estar.R;

import com.example.ti.estar.dal.UsuarioDAO;
import com.example.ti.estar.model.Usuario;

public class CriarContaActivity extends AppCompatActivity {
    private EditText edtNome, edtSenha, edtEmail;
    private Button btnCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnCad = findViewById(R.id.btnCad);
    }

    public void btnCriarConta(View view) {
        Usuario u = new Usuario();
        u.setNome(edtNome.getText().toString());
        u.setEmail(edtEmail.getText().toString());
        u.setSenha(edtSenha.getText().toString());
        u.setSaldo("2");
        if(UsuarioDAO.cadastrarUsuario(u, this)){
            UsuarioDAO.logarUsuario(u);
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Ocorreu Algum Erro no Banco de Dados. Se foda ai...", Toast.LENGTH_SHORT).show();
        }
    }
}