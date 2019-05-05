package br.com.alfa.modulo.testes;

import br.com.alfa.modulo.InstanciaDriver;
import br.com.alfa.modulo.paginas.PaginaConsultaCEP;
import br.com.alfa.modulo.paginas.PaginaRetornoConsultaCEP;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class PaginaConsultaCEPTest {
  private WebDriver webDriver;
  private PaginaConsultaCEP paginaConsultaCEP;
  private PaginaRetornoConsultaCEP paginaRetornoConsultaCEP;
  private static final int timeOutInSeconds = 30;

  @BeforeTest
  public void setup() {
    this.webDriver = InstanciaDriver.getDriver();
    webDriver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
    webDriver.manage().window().maximize();

    this.paginaConsultaCEP = new PaginaConsultaCEP(webDriver);
    this.paginaRetornoConsultaCEP = new PaginaRetornoConsultaCEP(webDriver);
  }

  @Test
  public void testConsultaPorCEP() {
    this.paginaConsultaCEP.informarCEP("74393580");
    this.paginaConsultaCEP.consultarCEP();

    boolean isCepValido = this.paginaRetornoConsultaCEP.getGridResultadoConsultaCEP().getText().contains("Rua SR 17");

    assertTrue(isCepValido);

    this.webDriver.close();
  }
}
