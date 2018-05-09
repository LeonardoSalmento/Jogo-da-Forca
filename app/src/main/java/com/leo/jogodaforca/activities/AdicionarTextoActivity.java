package com.leo.jogodaforca.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.leo.jogodaforca.App;
import com.leo.jogodaforca.R;
import com.leo.jogodaforca.models.Tema;
import com.leo.jogodaforca.models.Texto;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class AdicionarTextoActivity extends AppCompatActivity {
    @BindView(R.id.alternativas) RadioGroup radioGroup;
    @BindView(R.id.edit_texto) EditText editTexto;

    private Texto texto;
    private Box<Texto> textoBox;
    private long temaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_texto);
        ButterKnife.bind(this);

        textoBox = ((App)getApplication()).getBoxStore().boxFor(Texto.class);
        texto = new Texto();
        temaId = getIntent().getLongExtra("temaId",-1);
        Toast.makeText(this, "" + temaId, Toast.LENGTH_LONG);
    }

    @OnClick(R.id.btn_salvar_texto)
    public void salvarTexto(View view) {
        String text = editTexto.getText().toString();
        int radioButtonId = radioGroup.getCheckedRadioButtonId();

        if(editTexto.length() == 0) {
            editTexto.setError("Texto não pode estar vazio");
        }

        else if(radioButtonId == -1) {
            Toast.makeText(this, "Selecione palavra ou frase!", Toast.LENGTH_SHORT);
        }

        else {
            if (radioButtonId == R.id.eh_frase) {
                texto.setEhFrase(true);
            }

            texto.setTexto(text.trim());
            texto.getTemaToOne().setTargetId(temaId);
            textoBox.put(texto);

            finish();
        }
    }
}
