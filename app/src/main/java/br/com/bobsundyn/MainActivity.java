package br.com.bobsundyn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.bobsundyn.model.Produto;

public class MainActivity extends AppCompatActivity {

    EditText textNome, textImagem, textLink, textPreco;
    Button btnCadastrar;
    ListView listProduto;
    ArrayList<Produto> produtos = new ArrayList<>();
    ProdutoAdapter adapterProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNome = findViewById(R.id.textNome);
        textImagem = findViewById(R.id.textImagem);
        textLink = findViewById(R.id.textLink);
        textPreco = findViewById(R.id.textPreco);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        listProduto = findViewById(R.id.listProduto);

        adapterProdutos = new ProdutoAdapter(this, produtos);
        listProduto.setAdapter((ListAdapter) adapterProdutos);

        Toast.makeText(this, "Bem-Vindo á sua lista de compras!", Toast.LENGTH_SHORT).show();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = textNome.getText().toString();
                String imagem = textImagem.getText().toString();
                String link = textLink.getText().toString();
                String precoDigitado = textPreco.getText().toString();
                double preco = Double.parseDouble(precoDigitado);
                Produto produto = new Produto(nome, imagem, link, preco);
                produtos.add(produto);
                adapterProdutos.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        listProduto.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int i, long l) {
                final Produto produtoClicado = produtos.get(i);
                Toast.makeText(MainActivity.this, "Você clicou em " + produtoClicado, Toast.LENGTH_SHORT).show();
                AlertDialog alerta = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Excluir")
                        .setMessage("Deseja excluir o item " + produtoClicado + "?")
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                produtos.remove(produtoClicado);
                                adapterProdutos.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Operação cancelada", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alerta.show();
                return false;
            }
        });

    }
}