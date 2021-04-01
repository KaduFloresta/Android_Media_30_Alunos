package com.example.android_media_30_alunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String[]> notasAlunos = new ArrayList<>();
    String[] alunoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle args = getIntent().getExtras();
        alunoMain = args.getStringArray("aluno");

        Button btLogin = (Button) findViewById(R.id.btnCalcular);
        btLogin.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tNome = (TextView) findViewById(R.id.inputNome);
                TextView tDtNascimento = (TextView) findViewById(R.id.inputDtNascimento);
                TextView tEndereco = (TextView) findViewById(R.id.inputEndereco);
                TextView tNota1 = (TextView) findViewById(R.id.inputNota1);
                TextView tNota2 = (TextView) findViewById(R.id.inputNota2);
                TextView tNota3 = (TextView) findViewById(R.id.inputNota3);
                TextView tNota4 = (TextView) findViewById(R.id.inputNota4);

                String nome = tNome.getText().toString();
                float nota1 = Float.parseFloat(tNota1.getText().toString());
                String dtNascimento = tDtNascimento.getText().toString();
                float nota2 = Float.parseFloat(tNota2.getText().toString());
                String endereco = tEndereco.getText().toString();
                float nota3 = Float.parseFloat(tNota3.getText().toString());

                float nota4 = Float.parseFloat(tNota4.getText().toString());
                float media = ((nota1 + nota2 + nota3 + nota4) / 4);

                String[] novoAluno = {
                        nome,
                        dtNascimento,
                        endereco,
                        String.valueOf(nota1),
                        String.valueOf(nota2),
                        String.valueOf(nota3),
                        String.valueOf(nota4),
                        String.valueOf(media)
                };

                int length = notasAlunos.size() + 1;
                if (length > 30) {
                    notasAlunos.add(length, novoAluno);
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    startActivityForResult(intent, 2);

                    Bundle params = new Bundle();
                    params.putStringArray("aluno", novoAluno);
                    intent.putExtras(params);
                    startActivity(intent);
                } else {
                    throw new Error("Somente 30 alunos!");
                }
            }
        };
    }
}