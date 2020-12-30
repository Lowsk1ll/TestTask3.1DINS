import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    static WebDriver driver;
    String site = "https://habr.com/ru/";
    public DriverWrapper(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
    }
    public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(site);
        driver.manage().window().maximize();
    }

    public void close() {
            driver.quit();
        }


}
