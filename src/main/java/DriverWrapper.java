import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    WebDriver driver;
    String site = "https://habr.com/ru/";
    public DriverWrapper(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
    }
    public void init(){
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        this.driver.get(site);
        this.driver.manage().window().maximize();
    }

    public void close() {
            this.driver.quit();
        }


}
