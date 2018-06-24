package com.example.pedroarthurbarrantes.aplicacaodesirev3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pedroarthurbarrantes.aplicacaodesirev3.Database.DatabaseAccess;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrl = new ArrayList<>();
    private Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initImageBitmap();

    }

    private void initImageBitmap(){

        DatabaseAccess dbAc = DatabaseAccess.getInstance(getApplicationContext());
        dbAc.open();





        String n = "Estação de São Caetano do Sul";
        String valor = dbAc.getNome(n);

        mImageUrl.add("http://www.saocaetanodigital.com.br/wp-content/uploads/2014/12/Rodovi%C3%A1ria-e-Esta%C3%A7%C3%A3o-S%C3%A3o-Caetano.jpg");
        mNames.add(dbAc.getNome(valor));

        mImageUrl.add("https://static.panoramio.com.storage.googleapis.com/photos/large/17667128.jpg");
        mNames.add(dbAc.getNome("Estação de Santo André"));

        mImageUrl.add("http://trjs.com.br/images/rodoviaria_joao_setti.jpg");
        mNames.add("Estação de São Bernardo");


        mImageUrl.add("http://www.metro.sp.gov.br/sua-viagem/images/linhas/linha-5-lilas/campo-limpo/estacao-campo-limpo.jpg");
        mNames.add("Estação Campo Limpo");

        mImageUrl.add("http://www.metro.sp.gov.br/sua-viagem/images/linhas/linha-5-lilas/capao-redondo/estacao-capao-redondo.jpg");
        mNames.add(dbAc.getNome("Estação Capão Redondo"));

        mImageUrl.add("http://www.metro.sp.gov.br/sua-viagem/images/linhas/linha-5-lilas/vila-belezas/estacao-vila-belezas.jpg");
        mNames.add(dbAc.getNome("Estação Vila das Belezas"));

        mImageUrl.add("http://www.metro.sp.gov.br/sua-viagem/images/linhas/linha-5-lilas/giovanni-gronchi/estacao-giovanni-gronchi.jpg");
        mNames.add("Estação Giovanni Gronchi");

        mImageUrl.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Esta%C3%A7%C3%A3o_Santo_Amaro_Linha_5.jpg/300px-Esta%C3%A7%C3%A3o_Santo_Amaro_Linha_5.jpg");
        mNames.add("Estação Santo Amaro");

        mImageUrl.add("http://www.metro.sp.gov.br/sua-viagem/images/linhas/linha-5-lilas/largo-treze/estacao-largo-treze.jpg");
        mNames.add("Estação Largo Treze");

        mImageUrl.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Esta%C3%A7%C3%A3o_Adolfo_Pinheiro.jpg/300px-Esta%C3%A7%C3%A3o_Adolfo_Pinheiro.jpg");
        mNames.add("Estação Adolfo Pinheiro");

        mImageUrl.add("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Estacaoaltodaboavista_linha5_metrosp2.jpg/300px-Estacaoaltodaboavista_linha5_metrosp2.jpg");
        mNames.add("Estação Alto da Boa Vista");

        mImageUrl.add("http://www.metro.sp.gov.br/sua-viagem/images/linhas/linha-5-lilas/borba-gato/estacao-borba-gato.jpg");
        mNames.add("Estação Borba Gato");

        mImageUrl.add("http://www.metro.sp.gov.br/sua-viagem/images/linhas/linha-5-lilas/brooklin/estacao-brooklin.jpg");
        mNames.add("Estação Brooklin");


        dbAc.close();

        initRecyclerView();


    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrl,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }




}
