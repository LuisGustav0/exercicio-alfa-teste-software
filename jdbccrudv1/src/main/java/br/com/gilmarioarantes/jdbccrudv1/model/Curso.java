package br.com.gilmarioarantes.jdbccrudv1.model;

public class Curso {

    private Long id;
    private String nome;

    public Curso(){}

    public Curso(Long id, String nome){
        this.id = id;
        this.nome = nome;
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

    public String toString(){
        return "Id do curso: " + this.getId() + " Nome do curso: " + this.getNome();
    }
}
