package com.josuecamelo.com.gestocontas_jcamelo.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.josuecamelo.com.gestocontas_jcamelo.R;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabMain, fabExpenses, fabEarning;
    private boolean fabsHide = true;
    private DatePickerDialog.OnDateSetListener dateListner;
    private Toolbar mToolbar;
    private DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carregando fragmento principal
        getSupportFragmentManager().
                beginTransaction().
                add(R.id.fragmentContainer, new MainFragment()).
                commit();

        // Carregar os FABS
        fabMain = findViewById(R.id.fabMain);
        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHideFabs();
            }
        });

        fabExpenses = findViewById(R.id.fabExpenses);
        fabExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fabEarning = findViewById(R.id.fabEarnings);
        fabEarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void showHideFabs(){
        // Define a animação
        // 0 significa invisivel e 1 visivel
        // Indo de 0 a 1
        AlphaAnimation fadeAnimation = new AlphaAnimation(0,1);
        // Define a duração
        fadeAnimation.setDuration(1000);
        // Define o atraso
        fadeAnimation.setStartOffset(100);

        if(fabsHide){
            fabExpenses.setVisibility(View.VISIBLE);
            fabEarning.setVisibility(View.VISIBLE);
            fabExpenses.setAnimation(fadeAnimation);
            fabEarning.setAnimation(fadeAnimation);
        }else{
            fabExpenses.clearAnimation();
            fabEarning.clearAnimation();
            fabExpenses.setVisibility(View.GONE);
            fabEarning.setVisibility(View.GONE);
        }

        fabsHide = !fabsHide;
    }
}
