package org.dedira.calculadora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ResultadoAdaptador extends ArrayAdapter<String> {

    public ResultadoAdaptador(@NonNull Context contexto, ArrayList<String> lista) {
        super(contexto, 0, lista);
    }

    public View getView(
            int posicao,
            View visaoPreCarregada,
            ViewGroup pai
    ){

        String conta = getItem(posicao);

        if(visaoPreCarregada == null){
            visaoPreCarregada =
                    LayoutInflater.from(getContext()).inflate(
                            R.layout.linha,
                            pai,
                            false);
        }

    }




}






