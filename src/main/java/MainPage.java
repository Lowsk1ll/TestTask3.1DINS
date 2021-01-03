import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(xpath = "//button[@id='search-form-btn']")
    WebElement FindButton;

    @FindBy(xpath = "//input[@class='search-form__field']")
    WebElement FindField;

    public MainPage(){
        PageFactory.initElements(DriverWrapper.driver,this);
    }

    public void find(String findWord){
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(FindButton));
        FindButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(FindField));
        FindField.sendKeys(findWord);
        FindField.submit();
    }
}
