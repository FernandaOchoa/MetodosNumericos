package com.monsh.seriemaclaurin;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

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

    DecimalFormat decimales = new DecimalFormat("0.000000");
    MetodosMatematicos m = new MetodosMatematicos();

    //Constructor
    public MainActivity(){

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

    public void calcCos(View v) {
        m.polinomioSinEvaluar = "";
        m.polinomioSustituido = "";
        m.polinomioEvaluado = "";
        m.resultadoEvaluado = 0;

        a = edtValorN.getText().toString();
        if (!a.isEmpty()){
            n = Integer.parseInt(a);


            int fac;
            for (int i = 0; i <= n; i++) {
                fac = m.factorial(i);
                m.coseno(fac, i);
                m.resultados(fac, i);
            }
            m.rE = Double.parseDouble(decimales.format(m.getResultadoEvaluado()));

            tvValAppSerie.setText(String.valueOf(m.rE));

            errorAbsoluto(m.rE);
            errorRelativo(m.eA);
            errorPorcentual(m.eR);

            edtValorN.setText("");

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        } else {
            Snackbar sb = Snackbar.make(v, "Por favor ingresa un valor",Snackbar.LENGTH_SHORT);
            sb.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            sb.show();
        }

    }

    public void calcE(View view) {
        m.polinomioSinEvaluar = "";
        m.polinomioSustituido = "";
        m.polinomioEvaluado = "";
        m.resultadoEvaluado = 0;

        a = edtValorN.getText().toString();
        if (!a.isEmpty()){
        n = Integer.parseInt(a);

        int fac;
        for (int i = 0; i <= n; i++) {
            fac = m.factorial(i);
            m.e(fac, i);
            m.resultados(fac, i);
        }
        m.rE = Double.parseDouble(decimales.format(m.getResultadoEvaluado()));
        tvValAppSerie.setText(String.valueOf(m.rE));

        errorAbsoluto(m.rE);
        errorRelativo(m.eA);
        errorPorcentual(m.eR);

        edtValorN.setText("");

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } else {
            Snackbar sb = Snackbar.make(view, "Por favor ingresa un valor",Snackbar.LENGTH_SHORT);
            sb.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            sb.show();
        }
    }

    public void calcSen(View vi) {
        m.polinomioSinEvaluar = "";
        m.polinomioSustituido = "";
        m.polinomioEvaluado = "";
        m.resultadoEvaluado = 0;

        a = edtValorN.getText().toString();
        if (!a.isEmpty()){
        n = Integer.parseInt(a);

        int fac;
        for (int i = 0; i <= n; i++) {
            fac = m.factorial(i);
            m.seno(fac, i);
            m.resultados(fac, i);
        }
        m.rE = Double.parseDouble(decimales.format(m.getResultadoEvaluado()));
        tvValAppSerie.setText(String.valueOf(m.rE));

        errorAbsoluto(m.rE);
        errorRelativo(m.eA);
        errorPorcentual(m.eR);

        edtValorN.setText("");

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(vi.getWindowToken(), 0);
        } else {
            Snackbar sb = Snackbar.make(vi, "Por favor ingresa un valor",Snackbar.LENGTH_SHORT);
            sb.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            sb.show();
        }
    }


    public double errorAbsoluto(double resEv){
        m.eA = Math.abs(resEv - m.getResultadoReal());
        m.eA = Double.parseDouble(decimales.format(m.eA));
        tvEA.setText(String.valueOf(m.eA));
        return m.eA;
    }

    public double errorRelativo(double eRel){
        m.eR = (Math.abs(eRel)/m.getResultadoReal());
        m.eR = Double.parseDouble(decimales.format(m.eR));
        tvER.setText(String.valueOf(m.eR));
        return  m.eR;
    }

    public void errorPorcentual(double eRelat){
        m.eP = (eRelat * 100);
        m.eP = Double.parseDouble(decimales.format(m.eP));
        tvERP.setText(String.valueOf(m.eP));

    }

}