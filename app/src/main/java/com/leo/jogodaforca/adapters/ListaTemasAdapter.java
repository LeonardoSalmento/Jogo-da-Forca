package com.leo.jogodaforca.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.leo.jogodaforca.R;
import com.leo.jogodaforca.activities.AdicionarTextoActivity;
import com.leo.jogodaforca.activities.TextosActivity;
import com.leo.jogodaforca.models.Tema;
import com.leo.jogodaforca.models.Texto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.objectbox.Box;

public class ListaTemasAdapter extends RecyclerView.Adapter<ListaTemasAdapter.ViewHolder> {
    private Context context;
    private Tema tema;
    private Texto texto;
    private List<Tema> temas;
    private Box<Tema> temaBox;
    private Box<Texto> textoBox;

    public ListaTemasAdapter(Context context, List<Tema> temas, Box<Tema> temaBox) {
        this.context = context;
        this.temas = temas;
        this.temaBox = temaBox;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_tema) TextView txtTema;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tema, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Tema tema = this.temas.get(position);

        holder.txtTema.setText(tema.getNome());

        configurarClickCurto(holder.itemView, tema, position);
        configurarClickLongo(holder.itemView, tema, position);

    }

    @Override
    public int getItemCount() {
        return this.temas.size();
    }

    public void configurarClickCurto(final View itemView, final Tema tema, final int position) {
        itemView.setOnClickListener(view -> {
            context.startActivity(new Intent(context, TextosActivity.class).putExtra("temaId", tema.getId()));
        });
    }

    public void configurarClickLongo(final View itemView, final Tema tema, final int position) {
        itemView.setOnLongClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu_temas, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                if(item.getItemId() == R.id.adicionar_texto) {
                    adicionarTexto(itemView, tema, position);
                }

                return false;
            });

            popupMenu.show();
            return true;
        });
    }

    public void adicionarTexto(View view, Tema tema, int position) {
        Intent intent = new Intent(context, AdicionarTextoActivity.class);
        intent.putExtra("temaId", tema.getId());
        context.startActivity(intent);
        notifyItemChanged(position);
    }
}
