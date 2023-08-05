package org.dedira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtNumero01, txtNumero02;
    Button btnSomar, btnSubtrair, btnMultiplicar, btnDividir;
    TextView txtResultado;

    public void somar(View v) {
        String n1 = this.txtNumero01.getText().toString();
        String n2 = this.txtNumero02.getText().toString();
        if (n1.equals("") || n2.equals("")) {
            Toast.makeText(this, "Digite dois numeros", Toast.LENGTH_SHORT).show();
        } else {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            double soma = num1 + num2;

            this.txtResultado.setText("Resultado: " + soma);
        }
    }

    public void multiplicar(View v) {
        String n1 = this.txtNumero01.getText().toString();
        String n2 = this.txtNumero02.getText().toString();
        if (n1.equals("") || n2.equals("")) {
            Toast.makeText(this, "Digite dois numeros", Toast.LENGTH_SHORT).show();
        } else {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            double soma = num1 * num2;

            this.txtResultado.setText("Resultado: " + soma);
        }
    }

    public void subtrair(View v) {
        String n1 = this.txtNumero01.getText().toString();
        String n2 = this.txtNumero02.getText().toString();
        if (n1.equals("") || n2.equals("")) {
            Toast.makeText(this, "Digite dois numeros", Toast.LENGTH_SHORT).show();
        } else {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            double soma = num1 - num2;

            this.txtResultado.setText("Resultado: " + soma);
        }

    }

    public void dividir(View v) {
        String n1 = this.txtNumero01.getText().toString();
        String n2 = this.txtNumero02.getText().toString();
        if (n1.equals("") || n2.equals("")) {
            Toast.makeText(this, "Digite dois numeros", Toast.LENGTH_SHORT).show();
        } else {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            double soma = num1 / num2;

            this.txtResultado.setText("Resultado: " + soma);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtNumero01 = this.findViewById(R.id.txtNumero01);
        this.txtNumero02 = this.findViewById(R.id.txtNumero02);
        this.txtResultado = this.findViewById(R.id.txtResultado);

        this.btnSomar = this.findViewById(R.id.btnSoma);
        this.btnDividir = this.findViewById(R.id.btnDividir);
        this.btnSubtrair = this.findViewById(R.id.btnSubtrair);
        this.btnMultiplicar = this.findViewById(R.id.btnMultiplicar);

        this.btnSomar.setOnClickListener(v -> somar(v));
        this.btnDividir.setOnClickListener(v -> dividir(v));
        this.btnSubtrair.setOnClickListener(v -> subtrair(v));
        this.btnMultiplicar.setOnClickListener(v -> multiplicar(v));
    }
}