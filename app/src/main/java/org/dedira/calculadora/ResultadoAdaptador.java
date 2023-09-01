package org.dedira.calculadora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ResultadoAdaptador extends ArrayAdapter<String> {

    public ResultadoAdaptador(@NonNull Context context, ArrayList<String> lista) {
        super(context, 0, lista);
    }

    /**
     * @param posicao      A posição do item dentro do conjunto de dados cuja visualização desejamos.
     * @param precarregado A View antiga para reutilizar, se possível.
     *                     Observação: Você deve verificar se esta View
     *                     não é nula e é do tipo apropriado antes de usá-la.
     *                     Se não for possível usar esta View para exibir os dados,
     *                     este método pode criar uma nova View.
     * @param pai          O pai ao qual esta View será eventualmente anexada
     * @return View
     */
    public View getView(int posicao, View precarregado, ViewGroup pai) {

        // O valor que deve ser exibido
        String expressaoMatematica = this.getItem(posicao);

        // Cria uma nova View caso a antiga seja
        // impossível reutilizar ou não exista
        if (precarregado == null) {
            precarregado = LayoutInflater.from(this.getContext()).inflate(R.layout.linha, pai, false);
        }

    }
}
