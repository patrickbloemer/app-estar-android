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

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtSenha;
    private Button btnLogin, btnCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnCad = findViewById(R.id.btnCad);

        Usuario u = new Usuario();
        u.setNome("admin");
        u.setEmail("admin");
        u.setSenha("admin");
        u.setSaldo("2");
        UsuarioDAO.cadastrarUsuario(u, this);
    }

    public void btnLogin(View view) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = UsuarioDAO.retornarListaUsuarios(this);
        boolean i = false;
        String UsuarioLogadoNome;
        for (Usuario temp : usuarios) {
            if (temp.getEmail().toString().equals(edtEmail.getText().toString())) {
                if(temp.getSenha().toString().equals(edtSenha.getText().toString())){
                    UsuarioDAO.logarUsuario(temp);
                    Usuario u = new Usuario();
                    u = UsuarioDAO.retornarUsuario();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    i = true;
                }
            }
        }
        if(!i){
            Toast.makeText(this, "Ocorreu um erro ao fazer Login. Por favor, tente novamente.", Toast.LENGTH_SHORT).show();
        }
    }

    //Ativação do botão para criar conta
    public void btnCriarConta(View view) {
        Intent intent = new Intent(this, CriarContaActivity.class);
        startActivity(intent);
    }
}