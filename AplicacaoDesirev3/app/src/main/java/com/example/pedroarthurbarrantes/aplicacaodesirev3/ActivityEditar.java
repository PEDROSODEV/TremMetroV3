package com.example.pedroarthurbarrantes.aplicacaodesirev3;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.pedroarthurbarrantes.aplicacaodesirev3.Database.DatabaseAccess;

public class ActivityEditar extends AppCompatActivity{

    String newString,stringTeste,stringAc,stringEnd,stringHo,stringMap;
    TextView txtV,edtT,ed_ac,ed_end,ed_ho;
    ImageView mapV;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Bundle extras = getIntent().getExtras();
        if (!extras.isEmpty()){
            newString = extras.getString("IMPORTANT_VALUE");
        }
        txtV = findViewById(R.id.nomeImage);
        txtV.setText(newString);

        DatabaseAccess dbAc = DatabaseAccess.getInstance(getApplicationContext());
        dbAc.open();

        stringTeste = dbAc.getInfo(newString);
        stringAc = dbAc.getAco(newString);
        stringEnd = dbAc.getEnd(newString);
        stringHo = dbAc.getHor(newString);
        stringMap = dbAc.getMap(newString);

        ed_end = findViewById(R.id.endereco_et);
        ed_end.setText(stringEnd);
        ed_ho = findViewById(R.id.horatio_et);
        ed_ho.setText(stringHo);
        ed_ac = findViewById(R.id.acomodacoes_et);
        ed_ac.setText(stringAc);
        edtT = findViewById(R.id.info_et);
        edtT.setText(stringTeste);
        mapV = findViewById(R.id.mapa_img);
        Glide.with(getApplicationContext()).asBitmap().load(stringMap).into(mapV);

        dbAc.close();

    }


}
