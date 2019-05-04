package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExclusaoTeste {


    @Test
    public void deletaTurmaTest() {
        System.out.println("Executando o método deletaTurmaTest() da classe: " + this.getClass().getSimpleName());
        boolean result;
        try {
            result = new DeletaTurma().deletaTurma(new Long(100));
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }

    @Test
    public void deletaDisciplinaTest(){
        System.out.println("Executando o método deletaDisciplinaTest() da classe: " + this.getClass().getSimpleName());
        boolean result;
        try {
            result = new DeletaDisciplina().deletaDisciplina(new Long(100));
        } catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }

    @Test
    public void deletaCursoTest(){
        System.out.println("Executando o método deletaCursoTest() da classe: " + this.getClass().getSimpleName());
        boolean result;
        try {
            result = new DeletaCurso().deletaCurso(new Long(100));
        } catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }

    @Test
    public void deletaProfessorTest(){
        System.out.println("Executando o método deletaProfessorTest() da classe: " + this.getClass().getSimpleName());
        boolean result;
        try {
            result = new DeletaProfessor().deletaProfessor(new Long(100));
        } catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }

    @Test
    public void deletaAlunoTest(){
        System.out.println("Executando o método deletaAlunoTest() da classe: " + this.getClass().getSimpleName());
        boolean result;
        try {
            result = new DeletaAluno().deletaAluno(new Long(100));
        } catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
