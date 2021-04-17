package com.example.android_media_30_alunos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AlunosAdapter extends ArrayAdapter<Alunos> {
    public AlunosAdapter(Context context, ArrayList<Alunos> alunos) {
        super(context, 0, alunos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Alunos aluno = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itens_alunos, parent, false);
        }
        // Lookup view for data population
        TextView nome = (TextView) convertView.findViewById(R.id.txtListaNome);
        TextView dataNascimento = (TextView) convertView.findViewById(R.id.txtListaDtNascimento);
        TextView endereco = (TextView) convertView.findViewById(R.id.txtListaEndereco);
        TextView media = (TextView) convertView.findViewById(R.id.txtListaMedia);

        // Populate the data into the template view using the data object
        nome.setText("Nome: " + aluno.getNome());
        dataNascimento.setText("Data Nasc: " + aluno.getNascimento());
        endereco.setText("Endereço: " + aluno.getEndereco());
        media.setText("Média: " + String.valueOf(aluno.getMedia()));
        // Return the completed view to render on screen
        return convertView;
    }
}
