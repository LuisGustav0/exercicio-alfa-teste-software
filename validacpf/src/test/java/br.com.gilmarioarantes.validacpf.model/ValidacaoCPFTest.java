package br.com.gilmarioarantes.validacpf.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidacaoCPFTest {

  private ValidaCPF validaCPF;

  @Before
  public void setup() {
    validaCPF = new ValidaCPF();
  }

  @Test
  public void validarCPFSomenteNumero() {
    String CPF = "593.A29.420-88";

    boolean isOk = validaCPF.isCPF(CPF);

    assertFalse(isOk);
  }

  @Test
  public void validarCPFTamanhoMaiorQueOnze() {
    String CPF = "3213213123213213213213123";

    boolean isOk = validaCPF.isCPF(CPF);

    assertFalse(isOk);
  }

  @Test
  public void validarCPFInvalido() {
    List<String> listaCPF = Arrays.asList("00000000000", "11111111111", "22222222222", "33333333333", "44444444444",
        "55555555555", "66666666666", "77777777777", "88888888888", "99999999999");

    boolean isOk = false;

    for (String CPF : listaCPF) {
      isOk = validaCPF.isCPF(CPF);

      if(isOk) {
        break;
      }
    }

    assertFalse(isOk);
  }

  @Test
  public void validarCPFValido() {
    String CPF = "59334942088";

    boolean isOk = validaCPF.isCPF(CPF);

    assertTrue(isOk);
  }
}
