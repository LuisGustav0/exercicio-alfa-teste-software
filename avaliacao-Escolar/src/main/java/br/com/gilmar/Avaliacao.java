package br.com.gilmar;

/**
 * Created by gilmario on 26/02/17.
 */
public class Avaliacao {

  private boolean isNumeroMenorQueZero(double numero) {
    return numero < 0.0;
  }

  private boolean isNumeroMaiorQueDez(double numero) {
    return numero > 10;
  }

  private boolean isNotaMenorQueZero(double nota) {
    return isNumeroMenorQueZero(nota);
  }

  private boolean isNotaMaiorQueDez(double nota) {
    return isNumeroMaiorQueDez(nota);
  }

  private boolean isFaltaMenorQueZero(double falta) {
    return isNumeroMenorQueZero(falta);
  }

  private boolean isFaltaMaiorQueCargaHoraria(double falta, double cargaHoraria) {
    return falta > cargaHoraria;
  }

  private boolean isCargaHorariaMenorQueZero(double cargaHoraria) {
    return isNumeroMenorQueZero(cargaHoraria);
  }

  public String avalia(double nota1, double nota2, double faltas, double cargaHoraria) throws ValoresInvalidosException {
    String result;

    double percentualFaltas = (faltas / cargaHoraria);
    double media = (nota1 + nota2) / 2;

    if ((isNotaMenorQueZero(nota1) || isNotaMaiorQueDez(nota1)) || (isNotaMenorQueZero(nota2) || isNotaMaiorQueDez(nota2)) ||
        (isFaltaMenorQueZero(faltas) || isFaltaMaiorQueCargaHoraria(faltas, cargaHoraria)) || isCargaHorariaMenorQueZero(cargaHoraria)) {
      throw new ValoresInvalidosException();//result = "Valores Inválidos.";
    } else if (percentualFaltas > 0.25) {
      result = "Reprovado por Falta.";
    } else if (media < 3.0) {
      result = "Reprovado por Média.";
    } else if (media >= 3.0 && media < 6.0) {
      result = "Prova Extra.";
    } else {
      result = "Aprovado.";
    }

    return result;
  }

}
