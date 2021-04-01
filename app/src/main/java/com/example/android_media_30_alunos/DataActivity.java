package com.example.android_media_30_alunos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    String[] alunoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Bundle args = getIntent().getExtras();
        alunoData = args.getStringArray("aluno");

        TextView tNome = (TextView) findViewById(R.id.dataNome);
        TextView tDtNasciemento = (TextView) findViewById(R.id.dataDtNascimento);
        TextView tEndereco = (TextView) findViewById(R.id.dataEndereco);
        TextView tNota1 = (TextView) findViewById(R.id.dataNota1);
        TextView tNota2 = (TextView) findViewById(R.id.dataNota2);
        TextView tNota3 = (TextView) findViewById(R.id.dataNota3);
        TextView tNota4 = (TextView) findViewById(R.id.dataNota4);
        TextView tMedia = (TextView) findViewById(R.id.dataMedia);

        tNome.setText(alunoData[0]);
        tDtNasciemento.setText(alunoData[2]);
        tEndereco.setText(alunoData[1]);
        tNota1.setText(alunoData[3]);
        tNota2.setText(alunoData[4]);
        tNota3.setText(alunoData[5]);
        tNota4.setText(alunoData[6]);
        tMedia.setText(alunoData[7]);
    }
}