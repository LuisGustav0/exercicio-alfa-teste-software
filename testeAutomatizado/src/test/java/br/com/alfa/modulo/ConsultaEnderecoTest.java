package br.com.alfa.modulo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ConsultaEnderecoTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() {
        driver = InstanciaDriver.getDriver();
        baseUrl = "http://www.buscacep.correios.com.br/sistemas/buscacep/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void consultaPorCep() throws Exception {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).sendKeys("74393580");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sim'])[1]/following::input[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]"));
        if (webElement != null) {
            String texto = webElement.getText();
            Assert.assertTrue(texto.contains("Rua SR 17"));
        }
    }

    @Test
    public void consultaPorRua() throws Exception {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).sendKeys("Rua SR 17");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sim'])[1]/following::input[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[2]"));
        if (webElement != null) {
            String texto = webElement.getText();
            Assert.assertTrue(texto.contains("Parque Santa Rita"));
        }
    }

    @Test
    public void consultaPorBairro() throws Exception {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("relaxation")).sendKeys("Parque Santa Rita");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sim'])[1]/following::input[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[6]/td[1]"));
        if (webElement != null) {
            String texto = webElement.getText();
            Assert.assertTrue(texto.contains("Avenida Buritis"));
        }
    }

    @AfterTest
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

}
