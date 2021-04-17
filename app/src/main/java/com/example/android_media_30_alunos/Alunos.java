package com.example.android_media_30_alunos;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;

public class Alunos implements Parcelable {
    private String nome;
    private String endereco;
    private String nascimento;
    private float nota1;
    private float nota2;
    private float nota3;
    private float nota4;
    private float media;

    public Alunos(String nome, String nascimento, String endereco,float media) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.media = media;
    }

    public Alunos(String nome, String endereco, String nascimento, float nota1, float nota2, float nota3, float nota4, float media) {
        this.nome = nome;
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.media = media;
    }

    protected Alunos(Parcel in) {
        nome = in.readString();
        endereco = in.readString();
        nascimento = in.readString();
        nota1 = in.readFloat();
        nota2 = in.readFloat();
        nota3 = in.readFloat();
        nota4 = in.readFloat();
        media = in.readFloat();
    }

    public static final Creator<Alunos> CREATOR = new Creator<Alunos>() {
        @Override
        public Alunos createFromParcel(Parcel in) {
            return new Alunos(in);
        }

        @Override
        public Alunos[] newArray(int size) {
            return new Alunos[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEndereco() {

        return endereco;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }

    public String getNascimento() {

        return nascimento;
    }

    public void setNascimento(String nascimento) {

        nascimento = nascimento;
    }

    public float getNota1() {

        return nota1;
    }

    public void setNota1(float nota1) {

        this.nota1 = nota1;
    }

    public float getNota2() {

        return nota2;
    }

    public void setNota2(float nota2) {

        this.nota2 = nota2;
    }

    public float getNota3() {

        return nota3;
    }

    public void setNota3(float nota3) {

        this.nota3 = nota3;
    }

    public float getNota4() {

        return nota4;
    }

    public void setNota4(float nota4) {

        this.nota4 = nota4;
    }

    public float getMedia() {

        return media;
    }

    public void setMedia(float media) {

        this.media = media;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(nascimento);
        dest.writeFloat(nota1);
        dest.writeFloat(nota2);
        dest.writeFloat(nota3);
        dest.writeFloat(nota4);
        dest.writeFloat(media);
    }
}
