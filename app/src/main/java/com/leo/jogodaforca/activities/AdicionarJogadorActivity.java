package com.leo.jogodaforca.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.leo.jogodaforca.App;
import com.leo.jogodaforca.R;
import com.leo.jogodaforca.models.Jogador;
import com.leo.jogodaforca.models.Tema;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class AdicionarJogadorActivity extends AppCompatActivity {

    private Jogador jogador;
    private Box<Jogador> jogadorBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_jogador);
        ButterKnife.bind(this);
        jogadorBox = ((App)getApplication()).getBoxStore().boxFor(Jogador.class);
        jogador = new Jogador();

    }

    //continuar

}
