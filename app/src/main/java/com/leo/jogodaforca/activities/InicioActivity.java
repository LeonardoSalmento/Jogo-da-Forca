package com.leo.jogodaforca.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leo.jogodaforca.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iniciando_game)
    public void iniciandoJogo(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
