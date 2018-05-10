package com.leo.jogodaforca.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.leo.jogodaforca.App;
import com.leo.jogodaforca.R;
import com.leo.jogodaforca.adapters.ListaTemasAdapter;
import com.leo.jogodaforca.models.Tema;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class TemasActivity extends AppCompatActivity {
    @BindView(R.id.rv_lista_temas) RecyclerView recyclerTemas;

    private Box<Tema> temaBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);
        ButterKnife.bind(this);

        temaBox = ((App)getApplication()).getBoxStore().boxFor(Tema.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Tema> temas = temaBox.getAll();
        recyclerTemas.setLayoutManager(new LinearLayoutManager(this));
        ListaTemasAdapter adapter = new ListaTemasAdapter(this, temas, temaBox);
        recyclerTemas.setAdapter(adapter);
    }

    @OnClick(R.id.fab_adicionar_tema)
    public void abrirAdicionarTexto(View view) {
        startActivity(new Intent(this, AdicionarTemaActivity.class));
    }
}
