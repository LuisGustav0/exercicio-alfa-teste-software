package br.com.gilmarioarantes.jdbccrudv1.model;

import br.com.gilmarioarantes.jdbccrudv1.util.FormataData;

import java.sql.Timestamp;
import java.util.Date;

public class Aluno {
    private Long id;
    private String matricula;
    private String nome;
    private String sexo;
    private Timestamp dataNascimento;

    public Aluno(){}

    public Aluno(Long id, String matricula, String nome, String sexo, Timestamp dataNascimento){
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String toString(){
        FormataData fd = new FormataData();
        StringBuffer sb = new StringBuffer();
        sb.append("Id do Aluno; " + this.getId());
        sb.append("\nMatrícula do Aluno: " + this.getMatricula());
        sb.append("\nNome do Aluno: " + this.getNome());
        sb.append("\nSexo do Aluno: " + this.getSexo());
        sb.append("\nData de Nascimento do Aluno: " + fd.timeStampToString(this.getDataNascimento()));
        return sb.toString();
    }
}
