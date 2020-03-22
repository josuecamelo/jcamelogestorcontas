package com.josuecamelo.com.gestocontas_jcamelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carregando fragmento principal
        getSupportFragmentManager().
                beginTransaction().
                add(R.id.fragmentContainer, new MainFragment()).
                commit();
    }
}
