package com.leo.jogodaforca.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.leo.jogodaforca.App;
import com.leo.jogodaforca.R;
import com.leo.jogodaforca.adapters.ListaTemasAdapter;
import com.leo.jogodaforca.adapters.ListaTextosAdapter;
import com.leo.jogodaforca.models.Tema;
import com.leo.jogodaforca.models.Texto;
import com.leo.jogodaforca.models.Texto_;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class TextosActivity extends AppCompatActivity {
    @BindView(R.id.rv_lista_textos) RecyclerView recyclerTextos;

    private Box<Texto> textoBox;
    private long temaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textos);
        ButterKnife.bind(this);

        textoBox = ((App)getApplication()).getBoxStore().boxFor(Texto.class);
        temaId = getIntent().getLongExtra("temaId", -1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Texto> textos = textoBox.query().equal(Texto_.temaToOneId, temaId).build().find();
        recyclerTextos.setLayoutManager(new LinearLayoutManager(this));
        ListaTextosAdapter adapter = new ListaTextosAdapter(this, textos, textoBox);
        recyclerTextos.setAdapter(adapter);

        if(!textos.isEmpty()) {
            getSupportActionBar().setTitle(textos.get(0).getTemaToOne().getTarget().getNome());
        }
    }
}
