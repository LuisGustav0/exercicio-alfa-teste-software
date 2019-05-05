package br.com.alfa.modulo.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaConsultaCEP {

  @FindBy(name = "relaxation")
  private WebElement inputTextCEP;

  @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Sim'])[1]/following::input[1]")
  private WebElement btnConsultaCEP;

  private WebDriver webDriver;
  private static final int timeOutInSeconds = 30;

  public PaginaConsultaCEP(WebDriver webDriver) {
    this.webDriver = webDriver;
    this.webDriver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/");

    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(webDriver, timeOutInSeconds);
    PageFactory.initElements(factory, this);
  }

  private boolean isInputTextCEPNotNull() {
    return this.inputTextCEP != null;
  }

  private boolean isBtnConsultaCEPNotNull() {
    return this.btnConsultaCEP != null;
  }

  public void informarCEP(String cep) {
    if (isInputTextCEPNotNull()) {
      this.inputTextCEP.clear();
      this.inputTextCEP.sendKeys(cep);
    }
  }

  public void consultarCEP() {
    if (isBtnConsultaCEPNotNull()) {
      this.btnConsultaCEP.click();
    }
  }
}
