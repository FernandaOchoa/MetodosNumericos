package com.monsh.seriemaclaurin.activities;


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

import com.monsh.seriemaclaurin.R;

import java.text.DecimalFormat;

public class AlgoritmosActivity extends AppCompatActivity {
    double resultados[] = new double[2];
    DecimalFormat decimales = new DecimalFormat("0.000000");

    private EditText edtAx, edtBx, edtCx, edtDx, edtEx, edtA, edtB, edtEP;
    private Button btnBis, btnNew, btnSec, btnReg;
    private TextView tvRes, tvErr;

    private double ax, bx, cx, dx, e, a, b, error;
    private String f, g, h, i, j, k, l, o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algoritmos);
        bindViews();
    }

    private void bindViews() {
        //Vista panel funcion
        edtAx = (EditText) findViewById(R.id.edtAx);
        edtBx = (EditText) findViewById(R.id.edtBx);
        edtCx = (EditText) findViewById(R.id.edtCx);
        edtDx = (EditText) findViewById(R.id.edtDx);
        edtEx = (EditText) findViewById(R.id.edtE);

        //Vista panel Limites
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        edtEP = (EditText) findViewById(R.id.edtEP);

        //Vista panel botones
        btnBis = (Button) findViewById(R.id.btnBis);
        btnNew = (Button) findViewById(R.id.btnNew);
        btnSec = (Button) findViewById(R.id.btnSec);
        btnReg = (Button) findViewById(R.id.btnReg);

        //Vista panel Resultados
        tvRes = (TextView) findViewById(R.id.tvRaiz);
        tvErr = (TextView) findViewById(R.id.tvErr);
    }

    public void calcSecante(View vew) {
        getValuesFunction();
        getValues();
        if (!f.isEmpty() && !g.isEmpty() && !h.isEmpty() && !i.isEmpty() && !j.isEmpty()) {
            if (!k.isEmpty() && !l.isEmpty() && !o.isEmpty()) {
                secante(a, b, error);
            }
            Snackbar sb = Snackbar.make(vew, "Por favor ingresa un valor", Snackbar.LENGTH_SHORT);
            sb.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            sb.show();

        }
        cleanBoard(vew);

       /* double []values = {ax,bx,cx,dx,e};
        Intent i = new Intent(getApplicationContext(), GraphActivity.class);
        i.putExtra("Function Values",values);
        startActivity(i);*/
    }

    public void calcReglaF(View vi) {
        getValuesFunction();
        getValues();
        if (!f.isEmpty() && !g.isEmpty() && !h.isEmpty() && !i.isEmpty() && !j.isEmpty()) {
            if (!k.isEmpty() && !l.isEmpty() && !o.isEmpty()) {
                falsaPosicion(a, b, error);
            }
            Snackbar sb = Snackbar.make(vi, "Por favor ingresa un valor", Snackbar.LENGTH_SHORT);
            sb.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            sb.show();
        }
        cleanBoard(vi);
    }


    public void calcBis(View view) {
        getValuesFunction();
        getValues();
        if (!f.isEmpty() && !g.isEmpty() && !h.isEmpty() && !i.isEmpty() && !j.isEmpty()) {
            if (!k.isEmpty() && !l.isEmpty() && !o.isEmpty()) {
                biseccion(a, b, error);
            }
            Snackbar sb = Snackbar.make(view, "Por favor ingresa un valor", Snackbar.LENGTH_SHORT);
            sb.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            sb.show();
        }
        cleanBoard(view);
    }

    public double funcion(double x) {
        return ((ax * Math.pow(x, 4)) + (bx * Math.pow(x, 3)) + (cx * Math.pow(x, 2)) + (dx * x) + e);
    }

    public double derivada(double x) {
        return (funcion(x + 0.000001) - funcion(x)) / 0.000001;
    }

    public void calcNewton(View v) {
        a = Double.parseDouble(edtA.getText().toString());
        error = Double.parseDouble(edtEP.getText().toString());
        newtonRaphson(a, error);
    }

    private double[] newtonRaphson(double x1, double error) {
        getValuesFunction();
        String M;
        String EABS;
        double x2 = 0, errorAbs = 100;
        while (errorAbs > error) {
            x2 = x1 - funcion(x1) / derivada(x1);
            errorAbs = Math.abs((x2 - x1) / x2) * 100;
            x1 = x2;
        }
        M = String.valueOf(decimales.format(x1));
        EABS = String.valueOf(decimales.format(errorAbs));
        tvRes.setText(M);
        tvErr.setText(EABS);
        return new double[]{x1, errorAbs};
    }

    public double[] falsaPosicion(double a, double b, double error) {
        double m, fm, errorAbs = 1000, mAnt, fa, fb;

        fa = funcion(a);
        fb = funcion(b);
        m = ((b * fa) - (a * fb)) / (fa - fb);
        fm = funcion(m);

        System.out.println(" a   |   fa   |   b   |   fb   |   m   |   fm   ");

        while (errorAbs > error) {
            impresion(a, fa, b, fb, m, fm);
            if ((fa * fm) > 0) {
                a = m;
                fa = fm;
            } else {
                b = m;
                fb = fm;
            }
            mAnt = m;
            m = ((b * fa) - (a * fb)) / (fa - fb);
            fm = funcion(m);
            errorAbs = Math.abs((m - mAnt) / m) * 100;
        }

        setTexts(m, errorAbs);
        return new double[]{m, errorAbs};
    }

    public double[] biseccion(double a, double b, double error) {
        double m, fm, errorAbs = 100, fa, fb, mAnt;
        double algo[] = new double[]{1, 2};
        m = (a + b) / 2;
        fa = funcion(a);
        fb = funcion(b);
        fm = funcion(m);

        System.out.println(" a   |   fa   |   b   |   fb   |   m   |   fm   ");

        while (error < errorAbs) {
            mAnt = m;
            impresion(a, fa, b, fb, m, fm);
            if (fa * fm > 0) {
                a = m;
                fa = funcion(a);
            } else {
                b = m;
                fb = funcion(b);
            }
            m = (a + b) / 2;
            fm = funcion(m);

            errorAbs = Math.abs(((m - mAnt) / m) * 100);
        }
        setTexts(m, errorAbs);
        return new double[]{m, errorAbs};
    }

    public double[] secante(double a, double b, double error) {
        double fa, fm, errorAbs = 100, m, fb, mAnt;

        fa = funcion(a);
        fb = funcion(b);
        m = (a * fb - b * fa) / (fa - fb);
        fm = funcion(m);

        System.out.println(" a   |   fa   |   b   |   fb   |   m   |   fm   ");

        while (errorAbs > error) {
            mAnt = m;
            impresion(a, fa, b, fb, m, fm);
            a = b;
            b = m;

            fa = fb;
            fb = fm;

            m = (a * fb - b * fa) / (fb - fa);
            fm = funcion(m);

            errorAbs = Math.abs((m - mAnt) / m) * 100;
        }
        setTexts(m, errorAbs);
        return new double[]{m, errorAbs};
    }

    private void getValues() {
        k = edtA.getText().toString();
        l = edtB.getText().toString();
        o = edtEP.getText().toString();

        a = Double.parseDouble(k);
        b = Double.parseDouble(l);
        error = Double.parseDouble(o);
    }

    private void getValuesFunction() {
        f = edtAx.getText().toString();
        g = edtBx.getText().toString();
        h = edtCx.getText().toString();
        i = edtDx.getText().toString();
        j = edtEx.getText().toString();

        ax = Double.parseDouble(f);
        bx = Double.parseDouble(g);
        cx = Double.parseDouble(h);
        dx = Double.parseDouble(i);
        e = Double.parseDouble(j);
    }


    private void setTexts(double m, double errorAbs) {
        String M;
        String EABS;
        M = String.valueOf(m);
        EABS = String.valueOf(errorAbs);
        tvRes.setText(M);
        tvErr.setText(EABS);
    }

    private void cleanBoard(View v) {
        edtAx.setText("");
        edtBx.setText("");
        edtCx.setText("");
        edtDx.setText("");
        edtEx.setText("");
        edtA.setText("");
        edtB.setText("");
        edtEP.setText("");

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }


    private void impresion(double a, double fa,
                           double b, double fb, double m, double fm) {
        System.out.printf("%.5f|%.5f|%.5f|%.5f|%.5f|%.5f\n", a, fa, b, fb, m, fm);
    }
}