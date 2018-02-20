package com.monsh.seriemaclaurin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Instance Variables
    TextView tvTitulo, tvValAppSerie, tvEA, tvER, tvERP;
    Button btnSen, btnCos, btnE;
    TextView edtValorN;

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

    public void calcE(View view) {
        //Get Value From User
        String valF;
        valF = edtValorN.getText().toString();


        tvValAppSerie.setText(valF);
    }

    public void calcSen(View view){
        String valE;
        valE = edtValorN.getText().toString();

        tvValAppSerie.setText(valE);
    }

    public void calcCos(View view){
        String valC;
        valC = edtValorN.getText().toString();

        tvValAppSerie.setText(valC);
    }

}
