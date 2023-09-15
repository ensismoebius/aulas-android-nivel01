package org.dedira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricoDeContas extends AppCompatActivity {

    /**
     * Reserva espaço para o adaptador
     */
    private ResultadoAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_de_contas);

        // Instancia o adaptador
        this.adaptador = new ResultadoAdaptador(
                this,
                Informacoes.listaDeExpressoesMatematicas
        );

        // Recupera uma referencia a lista
        ListView lista = this.findViewById(R.id.lstContas);

        // Vincula a lista ao adaptador
        lista.setAdapter(this.adaptador);
    }
}






