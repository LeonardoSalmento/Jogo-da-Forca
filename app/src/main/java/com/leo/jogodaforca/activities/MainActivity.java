package com.leo.jogodaforca.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.leo.jogodaforca.R;
import com.leo.jogodaforca.models.Tema;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_adicionar_palavra)
    public void abrirAdicionarPalavra(View view) {
        startActivity(new Intent(this, TemasActivity.class));
    }

    @OnClick(R.id.btn_iniciar_jogo)
    public void abrirInciarJogo(View view) {
        startActivity(new Intent(this, JogoActivity.class));
    }
}
