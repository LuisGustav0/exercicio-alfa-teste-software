package br.com.gilmarioarantes.jdbccrudv1.model;

public class Disciplina {

    private Long id;
    private String nome;
    private double cargaHoraria;
    private Curso curso;

    public Disciplina(){}

    public Disciplina(Long id, String nome, double ch){
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = ch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
