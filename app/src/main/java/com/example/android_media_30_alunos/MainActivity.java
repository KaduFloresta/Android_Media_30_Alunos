package com.example.android_media_30_alunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;


public class MainActivity extends AppCompatActivity {
    List<Alunos> arrayAlunos = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tNome = (TextView) findViewById(R.id.inputNome);
        TextView tDtNascimento = (TextView) findViewById(R.id.inputDtNascimento);
        TextView tEndereco = (TextView) findViewById(R.id.inputEndereco);

        TextView tNota1 = (TextView) findViewById(R.id.inputNota1);
        TextView tNota2 = (TextView) findViewById(R.id.inputNota2);
        TextView tNota3 = (TextView) findViewById(R.id.inputNota3);
        TextView tNota4 = (TextView) findViewById(R.id.inputNota4);
        TextView MediaAluno  = (TextView) findViewById(R.id.dataMediaAluno);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        Button btnAddAluno = (Button) findViewById(R.id.btnAddAluno);
        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);
        Button btnRelatorio = (Button) findViewById(R.id.btnRelatorio);

        ListView listaAluno = new ListView(this);
        // Construct the data source
        ArrayList<Alunos> arrayOfAlunos = new ArrayList<Alunos>();
        // Create the adapter to convert the array to views
        AlunosAdapter adapter = new AlunosAdapter(this, arrayOfAlunos);
        listaAluno.setAdapter(adapter);

        // Regra para calcular a média
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tratamento se um ou mais campos das notas estão vazios.
                if ((tNota1.getText().toString().equals("")) ||
                    (tNota2.getText().toString().equals("")) ||
                    (tNota3.getText().toString().equals("")) ||
                    (tNota4.getText().toString().equals(""))){
                    abrirToast("Digite TODAS as notas para o cálculo!");
                }
                else {
                Float nota1 = Float.parseFloat(tNota1.getText().toString());
                Float nota2 = Float.parseFloat(tNota2.getText().toString());
                Float nota3 = Float.parseFloat(tNota3.getText().toString());
                Float nota4 = Float.parseFloat(tNota4.getText().toString());
                Float media = ((nota1 + nota2 + nota3 + nota4) / 4);

                MediaAluno.setText("Média: " + media.toString());
                abrirToast("Adicione o aluno á lista!");
            }}
        });

        // Evento Limpar campos
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tNome.setText(null);
                tDtNascimento.setText(null);
                tEndereco.setText(null);
                tNota1.setText(null);
                tNota2.setText(null);
                tNota3.setText(null);
                tNota4.setText(null);

                abrirToast("Formulário limpo!");
            }
        });

        // Regra para nova nota de aluno
        btnAddAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Float nota1 = parseFloat(tNota1.getText().toString());
                Float nota2 = parseFloat(tNota2.getText().toString());
                Float nota3 = parseFloat(tNota3.getText().toString());
                Float nota4 = parseFloat(tNota4.getText().toString());
                Float media = (nota1 + nota2 + nota3 + nota4) / 4;

                // Tratamento de campos vazios ou preenchido de forma errada.
                if (tNome.getText().length() == 0) {
                    abrirToast("Preencha o campo nome!");
                } else if (tNome.getText().length() < 6) {
                    abrirToast("Digite o nome completo!");
                } else if (tDtNascimento.getText().length() == 0) {
                    abrirToast("Preencha o campo data de nascimento!");
                } else if (tDtNascimento.getText().length() < 10) {
                    abrirToast("Digite a data como No exemplo:\n00/00/0000!");
                } else if ((tEndereco.getText().length() == 0) || (tEndereco.getText().length() < 5)) {
                    abrirToast("Digite o endereço como no exemplo:\nRua Fulano 150!");//
                } else {

                    // Add item to adapter
                    Alunos newAluno = new Alunos(
                            tNome.getText().toString(),
                            tDtNascimento.getText().toString(),
                            tEndereco.getText().toString(),
                            (float) media);
                    arrayAlunos.add(newAluno);

                    adapter.clear();
                    for (Alunos a : arrayAlunos) {
                        float MediaAluno = a.getMedia();
                        adapter.add(a);
                    }
                    abrirToast("Aluno adicionado á lista!");
                }
            }
        });

        // Relatorio
        btnRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TESTE", " Entrou aqui Primeiro: " + arrayAlunos.size());
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                Bundle params = new Bundle();
                params.putParcelableArrayList("array", (ArrayList<? extends Parcelable>) arrayAlunos);
                intent.putExtras(params);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Verifica se o requestCode recebido é o mesmo que o enviado
        if (requestCode == 2) {
            //Testa o retorno da activity
        }
    }

    private void abrirToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }
}