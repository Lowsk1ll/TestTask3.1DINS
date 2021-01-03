import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    @FindBy(xpath = "//a[contains(@href,'hubs')]")
    WebElement Hubs;
    @FindBy(xpath = "//a[@class='list-snippet__title-link']")
    WebElement Blog;


    public SearchPage() {
        PageFactory.initElements(DriverWrapper.driver,this);
    }
    public void openBlog(){
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(Hubs));
        Hubs.click();
        wait.until(ExpectedConditions.elementToBeClickable(Blog));
        Blog.click();
    }
}
