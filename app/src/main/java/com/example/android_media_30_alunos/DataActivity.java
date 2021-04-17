package com.example.android_media_30_alunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        ListView listaAluno = (ListView) findViewById(R.id.listaAlunos);
        TextView media = (TextView) findViewById(R.id.dataMedia);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                setResult(2, intent);
                finish();//terminando a activity
            }
        });

        Bundle args = getIntent().getExtras();
        ArrayList<Alunos> arrayOfAlunos = (ArrayList<Alunos>) args.getSerializable("array");
        Log.i("TESTE", this.getLocalClassName() + " Entrou aqui: " + arrayOfAlunos.size());

        AlunosAdapter adapter = new AlunosAdapter(this, arrayOfAlunos);
        listaAluno.setAdapter(adapter);

        float soma = 0;
        int cont = 0;
        for (Alunos a : arrayOfAlunos) {
            soma += a.getMedia();
            cont++;
        }
        media.setText("Media: " + String.format("%.2f",soma / cont));
    }
}