package br.com.gilmarioarantes.validacpf.model;

import org.junit.Before;
import org.junit.Test;

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
    String CPF = "00000000000";

    boolean isOk = validaCPF.isCPF(CPF);

    assertFalse(isOk);
  }

  @Test
  public void validarCPFValido() {
    String CPF = "59334942088";

    boolean isOk = validaCPF.isCPF(CPF);

    assertTrue(isOk);
  }
}
