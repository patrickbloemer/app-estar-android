package com.example.ti.estar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ti.estar.model.Usuario;

import java.util.ArrayList;

public class Banco extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "Estar.db";
    public static final int VERSAO_BANCO = 1;

    public static final String TIPO_TEXTO = " TEXT";
    public static final String TIPO_INTEIRO = " INTEGER";
    public static final String VIRGULA = ", ";


    public static final String SQL_CRIAR_TABELA_USUARIO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaUsuario.NOME_TABELA +
                    "( " + Contrato.TabelaUsuario._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaUsuario.NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.EMAIL + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.SENHA + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.SALDO + TIPO_TEXTO + ");";

    public static final String SQL_DELETAR_TABELA_USUARIO =
            "DROP TABLE IF EXISTS " + Contrato.TabelaUsuario.NOME_TABELA;

    public Banco(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_USUARIO);
        db.execSQL(SQL_CRIAR_TABELA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("Banco", Banco.SQL_DELETAR_TABELA_USUARIO);
        db.execSQL(SQL_DELETAR_TABELA_USUARIO);
    }

    public long cadastrarUsuario(Usuario u) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put(Contrato.TabelaUsuario.NOME, u.getNome());
        dados.put(Contrato.TabelaUsuario.EMAIL, u.getEmail());
        dados.put(Contrato.TabelaUsuario.SENHA, u.getSenha());
        dados.put(Contrato.TabelaUsuario.SALDO, u.getSaldo());

        return db.insert(Contrato.TabelaUsuario.NOME_TABELA, null, dados);
    }


    public ArrayList<Usuario> retornarUsuarios(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario u = new Usuario();

        String[] colunas = new String[]{
                Contrato.TabelaUsuario._ID,
                Contrato.TabelaUsuario.NOME,
                Contrato.TabelaUsuario.EMAIL,
                Contrato.TabelaUsuario.SENHA,
                Contrato.TabelaUsuario.SALDO
        };
//        Colocar o WHERE no terceiro parametro
//        Colocar o WHEREVALUES no quarto parametro

//        String where = Contrato.TabelaCidade.ESTADO + " = ?";
//        String[] valoresWhere = new String[]{
//                "PR"
////        };

        Cursor cursor = db.query(
                Contrato.TabelaUsuario.NOME_TABELA,
                colunas,
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            do {
                //Preecher a lista com os dados cursor
                u = new Usuario();
                u.setNome(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setSenha(cursor.getString(3));
                u.setSaldo(cursor.getString(4));
                usuarios.add(u);
            }while (cursor.moveToNext());
            return usuarios;
        }
        return null;
    }


}
