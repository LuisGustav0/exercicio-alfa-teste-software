package alfa.br.com.gilmario.modelo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvaliacaoTestBdd {

  private double nota1;
  private double nota2;
  private int faltas;
  private int cargaHoraria;
  private String resultadoEsperado;
  private Avaliacao avaliacao;

  @Before
  public void setup() {
    this.avaliacao = new Avaliacao();
  }

  @Given("^que quero testar valores invalidos$")
  @Test
  public void testaValoresInvalidos() {
    System.out.println("\nTestando Valores Inválidos!\n");
  }

  @When("^eu informar os valores invalidos (.*) e (.*) e (.*) e (.*)$")
  public void informarValoresInvalidos(double nota1, double nota2, int faltas, int cargaHoraria) {
    //assertFalse((nota1 > 0 && nota1 < 10) &&
    // (nota2 > 0 && nota2 < 10) &&
    // (faltas >= 0 && faltas < cargaHoraria));
    System.out.println("Obtendo um conjunto de valores inválidos.");
    this.nota1 = nota1;
    this.nota2 = nota2;
    this.faltas = faltas;
    this.cargaHoraria = cargaHoraria;
  }

  @Then("^o sistema reporta uma excecao do tipo DadosInvalidosException$")
  public void avaliandoResultado() {
    try {
      resultadoEsperado = avaliacao.avalia(nota1, nota2, faltas, cargaHoraria);
    } catch (Exception e) {
      assertTrue(e instanceof ValoresInvalidosException);
    }
  }

  @Given("^que eu quero testar a reprocao por falta$")
  public void testaReprovacaoPorFalta() {
    System.out.println("\nTestando reprovação por faltas!\n");
  }

  @When("^eu informar os valores (.*) e (.*) e (.*) e (.*) , cuja quantidade de faltas supera o limite permitido$")
  public void informarValoresQueReprovamPorFalta(double nota1, double nota2, int faltas, int cargaHoraria) {
    this.nota1 = nota1;
    this.nota2 = nota2;
    this.faltas = faltas;
    this.cargaHoraria = cargaHoraria;
  }

  @Then("^o sistema informa que o aluno foi reprovado por falta.$")
  public void avaliaReprovacaoPorFalta() {
    try {
      resultadoEsperado = avaliacao.avalia(nota1, nota2, faltas, cargaHoraria);

      System.out.print(resultadoEsperado);

      assertEquals("Reprovado por Falta.", resultadoEsperado);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Given("^que eu quero testar reprovacao por media$")
  public void testaReprovacaoPorMedia() {
    System.out.println("\nTestando reprovação por média!\n");
  }

  @When("^eu informar os valores (.*) e (.*) e (.*) e (.*) que garatem a reprovacao por media$")
  public void informarValoresQueReprovamPorMedia(double nota1, double nota2, int faltas, int cargaHoraria) {
    assertTrue((nota1 >= 0 && nota1 <= 10) && (nota2 >= 0 && nota2 <= 10) && (faltas >= 0 && faltas < cargaHoraria));
    System.out.println("Obtendo um conjunto de valores inválidos.");
    this.nota1 = nota1;
    this.nota2 = nota2;
    this.faltas = faltas;
    this.cargaHoraria = cargaHoraria;
  }

  @Then("^o sistema deve informar que o aluno foi reprovado por media$")
  public void avaliandoReprovacaoPorMedia() {
    try {
      resultadoEsperado = avaliacao.avalia(nota1, nota2, faltas, cargaHoraria);

      assertEquals("Reprovado por Média.", resultadoEsperado);
    } catch (Exception e) {
      assertTrue(e instanceof ValoresInvalidosException);
    }
  }

  @Given("^que eu quero testar a prova extra$")
  public void testaProvaExtra() {
    System.out.println("\nTestando prova extra!\n");
  }

  @When("^eu informar os valores (.*) e (.*) e (.*) e (.*) que garatem a prova extra$")
  public void informarValoresQueGeramProvaExtra(double nota1, double nota2, int faltas, int cargaHoraria) {
    this.nota1 = nota1;
    this.nota2 = nota2;
    this.faltas = faltas;
    this.cargaHoraria = cargaHoraria;
  }

  @Then("^o sistema deve informar que o aluno devera fazer uma prova extra")
  public void avaliaProvaExtra() {
    try {
      resultadoEsperado = avaliacao.avalia(nota1, nota2, faltas, cargaHoraria);

      assertEquals("Prova Extra.", resultadoEsperado);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Given("^que eu quero testar a aprovacao$")
  public void testaAprovacao() {
    System.out.println("\nTestando aprovação!\n");
  }

  @When("^eu informar os valores (.*) e (.*) e (.*) e (.*) que garatem a aprovacao$")
  public void informarValoresQueAprovam(double nota1, double nota2, int faltas, int cargaHoraria) {
    this.nota1 = nota1;
    this.nota2 = nota2;
    this.faltas = faltas;
    this.cargaHoraria = cargaHoraria;
  }

  @Then("^o sistema deve informar que o aluno foi aprovado$")
  public void avaliaAprovacao() {
    try {
      resultadoEsperado = avaliacao.avalia(nota1, nota2, faltas, cargaHoraria);

      assertEquals("Aprovado.", resultadoEsperado);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
