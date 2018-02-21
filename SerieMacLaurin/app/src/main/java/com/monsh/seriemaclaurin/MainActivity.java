package com.monsh.seriemaclaurin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by monsh on 12/02/2018.
 * @author Jacob, Fernanda
 */

public class MainActivity extends AppCompatActivity {
    //Instance Variables
    TextView tvTitulo, tvValAppSerie, tvEA, tvER, tvERP;
    Button btnSen, btnCos, btnE;
    TextView edtValorN;
    int v;

    // n iteraciones (EditText)
    String a;
    int n;

    //public static final double DX = 0.01;
    static final int OPCION_SENO = 1;
    static final int OPCION_COSENO = 2;
    static final int OPCION_EXPONENCIAL = 3;
    static final String[] ARRAY_SENO = {"Sen(x)", " + Cos(x)", " - Sen(x)", " - Cos(x)"};
    static final String[] ARRAY_COSENO = {"Cos(x)", " - Sen(x)", " - Cos(x)", " + Sen(x)"};
    static final String[] ARRAY_SENO_VALUE = {"Sen(0)", " + Cos(0)", " - Sen(0)", " - Cos(0)"};
    static final String[] ARRAY_COSENO_VALUE = {"Cos(0)", " - Sen(0)", " - Cos(0)", " + Sen(0)"};
    static final int[] SENO = {0, 1, 0, -1};
    static final int[] COSENO = {1, 0, -1, 0};
    String polinomioSinEvaluar, polinomioSustituido, polinomioEvaluado;
    double resultadoEvaluado;
    double resultadoReal;

    //Para evaluar las funciones calc 0.5 c
    double evaluar=0.5;

    //Constructor
    public MainActivity(){
        polinomioSinEvaluar = "";
        polinomioSustituido = "";
        polinomioEvaluado = "";
        resultadoEvaluado = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inject Views
        createViews();
    }

    //Initialize Views
    void createViews() {
        tvTitulo = (TextView) findViewById(R.id.txtTitulo);
        tvValAppSerie = (TextView) findViewById(R.id.tvVA);
        tvEA = (TextView) findViewById(R.id.tvEA);
        tvER = (TextView) findViewById(R.id.tvER);
        tvERP = (TextView) findViewById(R.id.tvERP);
        btnSen = (Button) findViewById(R.id.btnSen);
        btnCos = (Button) findViewById(R.id.btnCos);
        btnE = (Button) findViewById(R.id.btnE);
        edtValorN = (EditText) findViewById(R.id.edtValN);
    }

    public int factorial(int x) {
        if (x == 0) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    public void e(int fac, int i) {
        polinomioSinEvaluar += "e^x";
        polinomioSustituido += "e^0";
        polinomioEvaluado += String.valueOf(1);
        resultadoEvaluado += 1 * Math.pow(evaluar, i) / fac;
        resultadoReal = Math.pow(Math.E, evaluar);
    }

    public void coseno(int fac, int i) {
        polinomioSinEvaluar += ARRAY_COSENO[i % 4];
        polinomioSustituido += ARRAY_COSENO_VALUE[i % 4];
        polinomioEvaluado += String.valueOf(COSENO[i % 4]);
        resultadoEvaluado += COSENO[i % 4] * Math.pow(evaluar, i) / fac;
        resultadoReal = Math.cos(evaluar);
    }

    public void seno(int fac, int i) {
        polinomioSinEvaluar += ARRAY_SENO[i % 4];
        polinomioSustituido += ARRAY_SENO_VALUE[i % 4];
        polinomioEvaluado += String.valueOf(SENO[i % 4]);
        resultadoEvaluado += SENO[i % 4] * Math.pow(evaluar, i) / fac;
        System.out.println(resultadoEvaluado);
        resultadoReal = Math.sin(evaluar);
    }

    public void calcCos(View view) {
        polinomioSinEvaluar = "";
        polinomioSustituido = "";
        polinomioEvaluado = "";
        resultadoEvaluado = 0;

        a = edtValorN.getText().toString();
        n = Integer.parseInt(a);

        int fac;
        for (int i = 0; i <= n; i++) {
            fac = factorial(i);
            coseno(fac, i);
            resultados(fac, i);
        }
        tvValAppSerie.setText(String.valueOf(getResultadoEvaluado()));
    }

    public void calcE(View view) {
        polinomioSinEvaluar = "";
        polinomioSustituido = "";
        polinomioEvaluado = "";
        resultadoEvaluado = 0;

        a = edtValorN.getText().toString();
        n = Integer.parseInt(a);

        int fac;
        for (int i = 0; i <= n; i++) {
            fac = factorial(i);
            e(fac, i);
            resultados(fac, i);
        }
        tvValAppSerie.setText(String.valueOf(getResultadoEvaluado()));
    }

    public void calcSen(View view) {
        polinomioSinEvaluar = "";
        polinomioSustituido = "";
        polinomioEvaluado = "";
        resultadoEvaluado = 0;

        a = edtValorN.getText().toString();
        n = Integer.parseInt(a);

        int fac;
        for (int i = 0; i <= n; i++) {
            fac = factorial(i);
            seno(fac, i);
            resultados(fac, i);
        }
        tvValAppSerie.setText(String.valueOf(getResultadoEvaluado()));
    }

    private void resultados(int fac, int i) {
        polinomioSinEvaluar += "(x^" + i + ")/" + fac + "  ";
        polinomioEvaluado += "(x^" + i + ")/" + fac + "  ";
        polinomioSustituido += "(x^" + i + ")/" + fac + "  ";
    }

    public String getPolinomioSinEvaluar() {  return polinomioSinEvaluar;  }
    public String getPolinomioSustituido() {  return polinomioSustituido;  }
    public String getPolinomioEvaluado() {  return polinomioEvaluado;  }
    public double getResultadoEvaluado() {  return resultadoEvaluado;  }
    public double getResultadoReal() {  return resultadoReal;  }
}