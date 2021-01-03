import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyPage {
    @FindBy(xpath = "//a[contains(@href,'profile')]")
    WebElement Profile;
    @FindBy(xpath = "//*[@class='defination-list__value']")
    WebElement Date;
    @FindBy(xpath = "//*[@class='footer__link js-show_lang_settings']")
    WebElement Language;
    @FindBy(xpath = "//*[@for='hl_langs_en']")
    WebElement EngInterface;
    @FindBy(xpath = "//*[@class='btn btn_blue btn_huge btn_full-width js-popup_save_btn']")
    WebElement SaveButton;

    public CompanyPage(){
        PageFactory.initElements(DriverWrapper.driver,this);
    }
    public void CheckProfile(){
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(Profile));
        Profile.click();

    }
    public String CheckYear(){
        String GodOsnovaniya =Date.getText();
        return GodOsnovaniya;
    }

    public void ChangeLaunguage (){
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        JavascriptExecutor js = (JavascriptExecutor) DriverWrapper.driver;
        js.executeScript("window.scrollBy(0,2500)");
        Language.click();
        wait.until(ExpectedConditions.elementToBeClickable(EngInterface));
        EngInterface.click();
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        SaveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(Profile));
    }

}
