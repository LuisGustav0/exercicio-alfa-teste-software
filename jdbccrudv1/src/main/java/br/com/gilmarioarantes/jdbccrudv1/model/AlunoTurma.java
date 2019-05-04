package br.com.gilmarioarantes.jdbccrudv1.model;

public class AlunoTurma {
    private long id;
    private double nota1;
    private double nota2;
    private int frequencia;
    private boolean aprovacao;
    private Aluno aluno;
    private Turma turma;

    public double getNota1() {
        return nota1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public boolean isAprovacao() {
        if((nota1 + nota2)/2 >= 6.00){
            aprovacao = true;
        }else{
            aprovacao = false;
        }
        return aprovacao;
    }

    public void setAprovacao(boolean aprovacao) {
        this.aprovacao = aprovacao;
    }
}
