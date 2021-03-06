import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTest {
    DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeMethod
    void setUp(){driverWrapper.init();}

    @Test
    void Test(){
        MainPage main = new MainPage();
        SearchPage search = new SearchPage();
        CompanyPage company = new CompanyPage();
        main.find("DINS");
        search.openBlog();
        company.CheckProfile();
        Assert.assertEquals(company.CheckYear(),"1998 год");
        company.ChangeLaunguage();
        Assert.assertEquals(company.CheckYear(),"Since 1998");
    }
    @AfterMethod
    void end(){driverWrapper.close();}
}
