package br.com.gilmarioarantes.jdbccrudv1.model;

public class Turma {
    private Long id;
    private String semestre;
    private Disciplina disciplina;
    private Professor professor;

    public Turma(){}

    public Turma(Long id, String semestre, Disciplina disciplina, Professor professor){
        this.id = id;
        this.semestre = semestre;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


}
