package com.example.ti.estar.dal;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.ti.estar.model.Usuario;
import com.example.ti.estar.model.Veiculo;

public class UsuarioDAO {

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static Usuario usuarioLogado;

    public static boolean cadastrarUsuario(Usuario usuario, Context context){
        listaUsuarios.add(usuario);
        return true;
    }

    public static ArrayList<Usuario> retornarListaUsuarios(Context context) {
        try{
            return listaUsuarios;
        }catch(Exception e){
            return null;
        }
    }

    public static void logarUsuario(Usuario u){
        usuarioLogado = u;
    }

    public static Usuario retornarUsuario(){
        return usuarioLogado;
    }

    public static void deslogarUsuario(){
        usuarioLogado = null;
    }
}