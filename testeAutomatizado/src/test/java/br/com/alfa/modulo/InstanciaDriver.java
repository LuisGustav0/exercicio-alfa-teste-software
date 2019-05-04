package br.com.alfa.modulo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstanciaDriver {

    public static WebDriver getDriver() {
        String PROPRIEDADE_OS = "os.name";
        String OS_WINDOWS = "WIN";
        String DRIVER_WINDOWS = "src/test/resources/chromedriver.exe";
        String DRIVER_LINUX = "src/test/resources/chromedriver";

        WebDriver webDriver = null;

        String OS = System.getProperty(PROPRIEDADE_OS).toUpperCase();
        String urlDriver = OS.contains(OS_WINDOWS) ? DRIVER_WINDOWS : DRIVER_LINUX;

        System.setProperty("webdriver.chrome.driver", urlDriver);

        try {
            webDriver = new ChromeDriver();
        } catch (Exception e) {
            System.out.println("Erro ao instanciar o driver" + e);
        }

        return webDriver;
    }
}
