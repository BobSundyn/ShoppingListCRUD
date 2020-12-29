package br.com.bobsundyn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.bobsundyn.model.Produto;

public class ProdutoAdapter implements ProdutosAdapter {

    Context context;
    ArrayList<Produto> produtos;

    public ProdutoAdapter(Context context, ArrayList<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int i) {
        return produtos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.adapter_produto, viewGroup, false);
        }

        Produto produto = produtos.get(i);

        TextView textNome = view.findViewById(R.id.textNome);
        TextView textPreco = view.findViewById(R.id.textPreco);
        TextView textLink = view.findViewById(R.id.textLink);
        ImageView imageProduto = view.findViewById(R.id.imageProduto);

        textNome.setText(produto.nome);
        textLink.setText(produto.link);
        textPreco.setText(produto.preco +"");
        Picasso.get().load(produto.imagem).into(imageProduto);

        return view;
    }

    @Override
    public void notifyDataSetChanged() {
    }
}

