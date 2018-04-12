package com.monsh.seriemaclaurin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.monsh.seriemaclaurin.R;

public class MenuActivity extends AppCompatActivity {
    private WebView gitLink;
    private Button btnU1,btnu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initializeViews();

        showWebView();

    }

    private void showWebView() {
        gitLink.getSettings().setJavaScriptEnabled(true);
        gitLink.setWebViewClient(new WebViewClient());
        gitLink.loadUrl("https://github.com/FernandaOchoa/MetodosNumericos/blob/master/README.md");
    }

    private void initializeViews() {
        gitLink = (WebView) findViewById(R.id.webGit);
        btnU1 = (Button) findViewById(R.id.btnUnidad1);
        btnu2 = (Button)findViewById(R.id.btnUnidad2);
    }

    public void gotoUnidad1(View view) {
        Intent goUOne = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goUOne);
    }

    public void gotoUnidad2(View view) {
        Intent goUTwo = new Intent(getApplicationContext(), AlgoritmosActivity.class);
        startActivity(goUTwo);
    }
}
