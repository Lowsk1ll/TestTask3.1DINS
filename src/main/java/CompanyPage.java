import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyPage {
    @FindBy(xpath = "//a[contains(@href,'profile')]")
    WebElement profil;
    @FindBy(xpath = "//*[@class='defination-list__value']")
    WebElement data;
    @FindBy(xpath = "//*[@class='footer__link js-show_lang_settings']")
    WebElement language;
    @FindBy(xpath = "//*[@for='hl_langs_en']")
    WebElement engInt;
    @FindBy(xpath = "//*[@class='btn btn_blue btn_huge btn_full-width js-popup_save_btn']")
    WebElement saveButt;

    public CompanyPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void checkProfile(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(profil));
        profil.click();

    }
    public String checkYear(){
        String godOsnovaniya =data.getText();
        return godOsnovaniya;
    }

    public void ChangeLaunguage (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");
        language.click();
        wait.until(ExpectedConditions.elementToBeClickable(engInt));
        engInt.click();
        wait.until(ExpectedConditions.elementToBeClickable(saveButt));
        saveButt.click();
        wait.until(ExpectedConditions.elementToBeClickable(profil));
    }

}
