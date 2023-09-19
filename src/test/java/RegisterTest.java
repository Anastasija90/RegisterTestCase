import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage;
    @BeforeMethod
    public void setUp(){
        driver=browserOpen();
        registerPage=new RegisterPage(driver);
    }
    @Test
    public void registerTest(){
        registerPage.insertFirstName("Milica");
        registerPage.insertLastName("Jevtić");
        registerPage.insertAddress("Milutina Milankovića 15");
        registerPage.insertEmail("milicajevtic@gmail.com");
        registerPage.insertPhone("061554421");
        registerPage.genderButton();
        registerPage.hobbies();
        registerPage.languages();
        registerPage.skills();
        registerPage.country();
    }
    @AfterMethod
    public void after(){
    driver.quit();
    }
}
