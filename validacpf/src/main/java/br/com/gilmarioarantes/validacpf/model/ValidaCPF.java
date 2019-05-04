package br.com.gilmarioarantes.validacpf.model;

public class ValidaCPF {
  public boolean isCPF(String cpf) {
    boolean result = false;
    int[] numerosCpf = new int[11];
    int quantidadeZeros = 11 - cpf.length();
    int soma = 0;

    if (cpf == null) {
      return result;
    }

    cpf = cpf.replace("[^a-ZA-Z]", "");

    //valida se a quantidade de dígitos informados é maior de 11
    if (cpf.length() > 11) {
      return result;
    }

    //validar se existe algum caracter que não seja dígito
    for (int i = 0; i < cpf.length(); i++) {
      if (!Character.isDigit(cpf.charAt(i))) {
        return result;
      }
    }

    for (int i = 0; i < quantidadeZeros; i++) {
      numerosCpf[i] = 0;
    }

    int j = 0;
    for (int i = quantidadeZeros; i < 11; i++) {
      numerosCpf[i] = Integer.parseInt(cpf.substring(j, j + 1));
      j++;
    }


    //valida se todos os números são iguais
    if (numerosCpf[0] == numerosCpf[1] &&
        numerosCpf[1] == numerosCpf[2] &&
        numerosCpf[2] == numerosCpf[3] &&
        numerosCpf[3] == numerosCpf[4] &&
        numerosCpf[4] == numerosCpf[5] &&
        numerosCpf[5] == numerosCpf[6] &&
        numerosCpf[6] == numerosCpf[7] &&
        numerosCpf[7] == numerosCpf[8] &&
        numerosCpf[8] == numerosCpf[9] &&
        numerosCpf[9] == numerosCpf[10]) {
      return result;
    }

    //calculo do primeiro dígito
    for (int i = 0; i < numerosCpf.length - 2; i++) {
      soma += numerosCpf[i] * (10 - i);
    }

    int restoDivisaoPrimeiroDigito = (soma % 11);

    int primeiroDigito = 0;
    if (restoDivisaoPrimeiroDigito < 2) {
      primeiroDigito = 0;
    } else {
      primeiroDigito = 11 - restoDivisaoPrimeiroDigito;
    }

    //Cálculo do segundo dígito
    soma = 0;
    for (int i = 0; i < numerosCpf.length - 1; i++) {
      soma += numerosCpf[i] * (11 - i);
    }

    int restoDivisaoSegundoDigito = (soma % 11);

    int segundoDigito = 0;
    if (restoDivisaoSegundoDigito < 2) {
      segundoDigito = 0;
    } else {
      segundoDigito = 11 - restoDivisaoSegundoDigito;
    }

    result = (primeiroDigito == numerosCpf[9]) && (segundoDigito == numerosCpf[10]);

    return result;
  }

}
