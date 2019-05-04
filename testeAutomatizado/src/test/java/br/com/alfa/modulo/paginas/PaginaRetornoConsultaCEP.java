package br.com.alfa.modulo.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaRetornoConsultaCEP {

   @FindBy(name = "/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]")
    private WebElement gridResultadoConsultaCEP;

    private WebDriver webDriver;
    private static final int timeOutInSeconds = 30;

    public PaginaRetornoConsultaCEP(WebDriver webDriver) {
        this.webDriver = webDriver;

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(webDriver, timeOutInSeconds);
        PageFactory.initElements(factory, this);
    }

    public WebElement getGridResultadoConsultaCEP() {
        return this.gridResultadoConsultaCEP;
    }
}
