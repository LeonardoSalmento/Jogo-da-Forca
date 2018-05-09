package com.leo.jogodaforca.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leo.jogodaforca.R;
import com.leo.jogodaforca.models.Texto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.objectbox.Box;

public class ListaTextosAdapter extends RecyclerView.Adapter<ListaTextosAdapter.ViewHolder> {
    private Context context;
    private Texto texto;
    private List<Texto> textos;
    private Box<Texto> textoBox;

    public ListaTextosAdapter(Context context, List<Texto> textos, Box<Texto> textoBox) {
        this.context = context;
        this.textos = textos;
        this.textoBox = textoBox;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_texto) TextView txtTexto;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_texto, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        final Texto texto = this.textos.get(position);

        holder.txtTexto.setText(texto.getTexto());
    }

    @Override
    public int getItemCount() {
        return this.textos.size();
    }
}
