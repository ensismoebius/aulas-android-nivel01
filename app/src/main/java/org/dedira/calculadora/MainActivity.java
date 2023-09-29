package org.dedira.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnce;
    Button btnIgual, btnMais, btnMenos, btnMult, btnDiv, btnAbre, btnFecha;

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Informacoes.listaDeExpressoesMatematicas = new ArrayList<>();

        // Vincula a abertura do histórico
        // ao clique na caixa de texto
        this.txtResultado = this.findViewById(R.id.txtFormula);
        this.txtResultado.setOnClickListener(v -> {
            Intent intencao = new Intent(this, HistoricoDeContas.class);

            startActivity(intencao);
        });

        this.btnIgual = this.findViewById(R.id.btnIgual);
        this.btnMais = this.findViewById(R.id.btnSoma);
        this.btnMenos = this.findViewById(R.id.btnSubtracao);
        this.btnMult = this.findViewById(R.id.btnMultiplicacao);
        this.btnDiv = this.findViewById(R.id.btnDivisao);
        this.btnAbre = this.findViewById(R.id.btnAbreParenteses);
        this.btnFecha = this.findViewById(R.id.btnFecharParenteses);

        this.btn1 = this.findViewById(R.id.btn1);
        this.btn2 = this.findViewById(R.id.btn2);
        this.btn3 = this.findViewById(R.id.btn3);
        this.btn4 = this.findViewById(R.id.btn4);
        this.btn5 = this.findViewById(R.id.btn5);
        this.btn6 = this.findViewById(R.id.btn6);
        this.btn7 = this.findViewById(R.id.btn7);
        this.btn8 = this.findViewById(R.id.btn8);
        this.btn9 = this.findViewById(R.id.btn9);
        this.btn0 = this.findViewById(R.id.btn0);
        this.btnce = this.findViewById(R.id.btnCe);

        this.btnIgual.setOnClickListener(v -> {
            Informacoes.listaDeExpressoesMatematicas.add(this.txtResultado.getText().toString());
            this.txtResultado.setText(Interpretador.avaliar(this.txtResultado.getText().toString()));
        });

        this.btnMais.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "+");
        });

        this.btnMenos.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "-");
        });

        this.btnMult.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "*");
        });

        this.btnDiv.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "/");
        });

        this.btnAbre.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "(");
        });

        this.btnFecha.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + ")");
        });

        this.btn1.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "1");
        });

        this.btn2.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "2");
        });

        this.btn3.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "3");
        });

        this.btn4.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "4");
        });

        this.btn5.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "5");
        });
        this.btn6.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "6");
        });

        this.btn7.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "7");
        });


        this.btn8.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "8");
        });

        this.btn9.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "9");
        });

        this.btn0.setOnClickListener(v -> {
            this.txtResultado.setText(this.txtResultado.getText().toString() + "0");
        });

        this.btnce.setOnClickListener(v -> {
            this.txtResultado.setText("");
        });
    }

    // Novo!
    @Override
    protected void onResume() {
        super.onResume();
        this.txtResultado.setText(Informacoes.expressaoAtual);
    }
}






