import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    @FindBy(xpath = "//a[contains(@href,'hubs')]")
    WebElement HUBS;
    @FindBy(xpath = "//a[@class='list-snippet__title-link']")
    WebElement BLOG;


    public SearchPage() {
        PageFactory.initElements(DriverWrapper.driver,this);
    }
    public void openBlog(){
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(HUBS));
        HUBS.click();
        wait.until(ExpectedConditions.elementToBeClickable(BLOG));
        BLOG.click();
    }
}
