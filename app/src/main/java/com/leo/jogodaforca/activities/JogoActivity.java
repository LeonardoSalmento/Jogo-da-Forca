package com.leo.jogodaforca.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leo.jogodaforca.App;
import com.leo.jogodaforca.R;
import com.leo.jogodaforca.models.Rodada;
import com.leo.jogodaforca.models.Tema;
import com.leo.jogodaforca.models.Texto;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class JogoActivity extends AppCompatActivity {
    @BindView(R.id.edit_letras) EditText editLetras;
    @BindView(R.id.layout_palavra) LinearLayout layoutPalavra;
    @BindView(R.id.txt_ver_tema) TextView txtVerTema;
    @BindView(R.id.txt_letras_erradas) TextView txtLetrasErradas;

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

    public Texto getTextoSorteado() {
        Texto texto = rodada.sortearPalavras(textoBox, temaBox);

        return texto;
    }

    public List<TextView> listarTextos() {
        Texto textoSorteado = getTextoSorteado();
        List<TextView> textViews = new ArrayList<>();
        txtVerTema.setText(textoSorteado.getTemaToOne().getTarget().getNome());

        for(int i = 0; i < textoSorteado.getTexto().length(); i++) {
            TextView textView = new TextView(this);
            textView.setText("-");
            textView.setId(i);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(20);
            textView.setPadding(10,10,10,10);
            layoutPalavra.addView(textView);
            textViews.add(textView);
        }

        return textViews;

    }
}
