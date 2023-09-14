package org.dedira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class HistoricoDeContas extends AppCompatActivity {


    private final ArrayList<String> referencia;

    public HistoricoDeContas(ArrayList<String> lista){
        this.referencia = lista;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_de_contas);


    }
}