import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTest {
    DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeMethod
    void setUp(){driverWrapper.init();}

    @Test
    void Test(){
        MainPage main = new MainPage(driverWrapper.driver);
        SearchPage search = new SearchPage(driverWrapper.driver);
        CompanyPage company = new CompanyPage(driverWrapper.driver);
        main.find(driverWrapper.driver,"DINS");
        search.openBlog(driverWrapper.driver);
        company.checkProfile(driverWrapper.driver);
        Assert.assertEquals(company.checkYear(),"1998 год");
        company.ChangeLaunguage(driverWrapper.driver);
        Assert.assertEquals(company.checkYear(),"Since 1998");
    }
}
