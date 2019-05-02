package br.com.gilmar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvaliacaoTest {

  private Avaliacao avaliacao;

  @Before
  public void setup() {
    avaliacao = new Avaliacao();
  }

  //CT01
  @Test(expected = ValoresInvalidosException.class)
  public void testFaltaMaiorCargaHorariaComCargaHorariaZero() throws ValoresInvalidosException {
    avaliacao.avalia(7.0, 6.0, 5, 0);
  }

  //CT02
  @Test(expected = ValoresInvalidosException.class)
  public void testFaltaMaiorCargaHoraria() throws ValoresInvalidosException {
    avaliacao.avalia(7.0, 6.0, 96, 48);
  }

  //CT03
  @Test(expected = ValoresInvalidosException.class)
  public void testNota1MenorQueZero() throws ValoresInvalidosException {
    avaliacao.avalia(-7.0, 6.0, 5, 96);
  }

  //CT04
  @Test(expected = ValoresInvalidosException.class)
  public void testComNota1MaiorQueDez() throws ValoresInvalidosException {
    avaliacao.avalia(11.0, 6.0, 5, 96);
  }

  //CT05
  @Test(expected = ValoresInvalidosException.class)
  public void testNota2MenorQueZero() throws ValoresInvalidosException {
    avaliacao.avalia(8.0, -1.0, 5, 96);
  }

  //CT06
  @Test(expected = ValoresInvalidosException.class)
  public void testNota2MaiorQueDez() throws ValoresInvalidosException {
    avaliacao.avalia(8.0, 11.0, 5, 96);
  }

  //CT07
  @Test(expected = ValoresInvalidosException.class)
  public void testeFaltaMenorQueZero() throws ValoresInvalidosException {
    avaliacao.avalia(8.0, 7.0, -3, 96);
  }

  //CT08
  @Test(expected = ValoresInvalidosException.class)
  public void testeValorInvalido08() throws ValoresInvalidosException {
    avaliacao.avalia(8.0, 7.0, -3, 96);
  }

  //CT09
  @Test(expected = ValoresInvalidosException.class)
  public void testCargaHorariaMenorQueZero() throws ValoresInvalidosException {
    avaliacao.avalia(8.0, 7.0, 97, -1);
  }

  //CT10
  @Test(expected = ValoresInvalidosException.class)
  public void testCargaHorariaMenorQueZero2() throws ValoresInvalidosException {
    avaliacao.avalia(8.0, 7.0, 16, -1);
  }

  //CT11
  @Test
  public void testReprovadoPorFaltaPercentualAcimaDeZeroVirgulaVinteCinco() throws ValoresInvalidosException {
    String resultado = avaliacao.avalia(8.0, 7.0, 28, 97);

    assertEquals("Reprovado por Falta.", resultado);
  }

  //CT12
  @Test
  public void testReprovadoPorMediaMenorQueTresVirgulaZero() throws ValoresInvalidosException {
    String resultado = avaliacao.avalia(2.0, 3.0, 15, 96);

    assertEquals("Reprovado por Média.", resultado);
  }

  //CT13 media >= 3.0 && media < 6.0
  @Test
  public void testProvaExtraMediaMaiorOuIgualTresVirgulaZeroAndMediaMaiorQueSeisVirgulaZero() throws ValoresInvalidosException {
    String resultado = avaliacao.avalia(4.0, 5.0, 15, 96);

    assertEquals("Prova Extra.", resultado);
  }

  //CT14
  @Test
  public void testAprovadoPorFaltaPercentualAbaixoDeZeroVirgulaVinteCincoAndMediaAcimaDeSeisVirgulaZero() throws ValoresInvalidosException {
    String resultado = avaliacao.avalia(7.0, 8.0, 15, 96);

    assertEquals("Aprovado.", resultado);
  }
}
