package br.com.alfa.modulo;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class ValidaCPFTest {
    private WebDriver driver;
    private String baseUrl;
    private final StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = InstanciaDriver.getDriver();
        baseUrl = "http://www.geradorcpf.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testaCPFInvalido() {
        driver.get(baseUrl + "/validar-cpf.htm");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("cpf")).clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("cpf")).sendKeys("02531296130");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("botaoValidarCPF")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String cpfInvalido = driver.findElement(By.id("saida")).getText();
        Assert.assertEquals(cpfInvalido, "CPF Inválido!");
    }

    @Test
    public void testaCPFValido() {
        driver.get(baseUrl + "/validar-cpf.htm");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("cpf")).clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("cpf")).sendKeys("02531296131");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("botaoValidarCPF")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String cpfInvalido = driver.findElement(By.id("saida")).getText();
        Assert.assertEquals(cpfInvalido, "CPF Válido!");
    }

    @AfterTest
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
