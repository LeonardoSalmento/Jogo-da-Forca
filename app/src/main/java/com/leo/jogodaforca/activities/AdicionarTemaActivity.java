package com.leo.jogodaforca.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leo.jogodaforca.App;
import com.leo.jogodaforca.R;
import com.leo.jogodaforca.models.Tema;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class AdicionarTemaActivity extends AppCompatActivity {
    @BindView(R.id.edit_tema) EditText editTema;

    private Tema tema;
    private Box<Tema> temaBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tema);
        ButterKnife.bind(this);
        temaBox = ((App)getApplication()).getBoxStore().boxFor(Tema.class);
        tema = new Tema();
    }

    @OnClick(R.id.btn_salvar_tema)
    public void salvarTema(View view) {
        String txtTema = editTema.getText().toString();

        if(txtTema.length() == 0) {
            editTema.setError("Tema não pode estar vazio!");
        }

        else {
            tema.setNome(txtTema.trim());
            temaBox.put(tema);

            finish();
        }

    }
}
