package com.leo.jogodaforca.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.leo.jogodaforca.App;
import com.leo.jogodaforca.R;
import com.leo.jogodaforca.models.Rodada;
import com.leo.jogodaforca.models.Tema;
import com.leo.jogodaforca.models.Texto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.objectbox.Box;

public class JogoActivity extends AppCompatActivity {
    @BindView(R.id.txt_textos) TextView txtTextos;

    private Rodada rodada;
    private Box<Texto> textoBox;
    private Box<Tema> temaBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        ButterKnife.bind(this);

        temaBox = ((App)getApplication()).getBoxStore().boxFor(Tema.class);
        textoBox = ((App)getApplication()).getBoxStore().boxFor(Texto.class);
        rodada = new Rodada();

        listarTextos();
    }

    public void listarTextos() {
        List<Texto> txtsSorteados = rodada.sortearPalavras(textoBox, temaBox);
        String textosSorteados = "";

        for(int i = 0; i < txtsSorteados.size(); i++) {
            textosSorteados += txtsSorteados.get(i).getTexto() + "\n";
        }

        txtTextos.setText("Tema: " + txtsSorteados.get(0).getTemaToOne().getTarget().getNome() +
                "\n" + textosSorteados);
    }
}
