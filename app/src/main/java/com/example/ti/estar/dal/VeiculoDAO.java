package com.example.ti.estar.dal;

import android.util.Log;
import android.widget.Toast;
import com.example.ti.estar.dal.UsuarioDAO;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.ti.estar.model.Usuario;
import com.example.ti.estar.model.Veiculo;

public class VeiculoDAO {

    private static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public static boolean cadastrarVeiculo(Veiculo v){
        Usuario u = (UsuarioDAO.retornarUsuario());
        v.setUsuarioEmail(u.getEmail());
        veiculos.add(v);
        return true;
    }
    public static ArrayList<Veiculo> retornarListaVeiculos(){
        return(veiculos);
    }
    public static ArrayList<Veiculo> retornarVeiculosDoUsuarioLogado(){
        Usuario u = new Usuario();
        u = UsuarioDAO.retornarUsuario();
        ArrayList veiculosUsuarioLogado = new ArrayList();
        for (Veiculo v : veiculos){
            if(v.getUsuarioEmail() == u.getEmail()){
                veiculosUsuarioLogado.add(v);
            }
        }
        return veiculosUsuarioLogado;
    }
}