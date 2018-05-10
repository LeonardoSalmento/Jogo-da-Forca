package com.leo.jogodaforca.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leo.jogodaforca.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_adicionar_palavra)
    public void abrirAdicionarPalavra(View view) {
        startActivity(new Intent(this, TemasActivity.class));
    }

    @OnClick(R.id.btn_novo_jogo)
    public void abrirInciarJogo(View view) {
        startActivity(new Intent(this, JogoActivity.class));
    }

    @OnClick(R.id.btn_ranking)
    public void abrirRanking(View view) {
        //ir para ranking
    }

}
