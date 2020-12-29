package br.com.bobsundyn;

import android.view.View;
import android.view.ViewGroup;

public interface ProdutosAdapter {
    int getCount();

    Object getItem(int i);

    long getItemId(int i);

    View getView(int i, View view, ViewGroup viewGroup);

    void notifyDataSetChanged();
}
