import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage extends BasePage{
    @FindBy (xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy (xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
    WebElement lastName;
    @FindBy (xpath = "//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")
    WebElement addressTextArea;
    @FindBy (xpath = "//*[@id=\"eid\"]/input")
    WebElement emailTextArea;
    @FindBy (xpath = "//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")
    WebElement phoneNumber;
    @FindBy (xpath = "//input[@value='FeMale']")
    WebElement gender;
    @FindBy (id = "checkbox1")
    WebElement cricket;
    @FindBy (id = "checkbox3")
    WebElement hockey;
    @FindBy (id = "msdd")
    WebElement languagesDropDown;
    @FindBy (linkText = "Dutch")
    WebElement languageDutch;
    @FindBy (tagName ="body")
    WebElement bodyElement;
    @FindBy (xpath ="//*[@id=\"Skills\"]")
    WebElement skillsDropDown;
    @FindBy (id = "countries")
    WebElement countryDropDown;
    public RegisterPage(ChromeDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void insertFirstName(String name){
        firstName.sendKeys(name);
    }
    public void insertLastName(String lastname){
        lastName.sendKeys(lastname);
    }
    public void insertAddress(String address){
        addressTextArea.sendKeys(address);
    }
    public void insertEmail(String email){
        emailTextArea.sendKeys(email);
    }
    public void insertPhone(String phone){
        phoneNumber.sendKeys(phone);
    }
    public void genderButton(){
        gender.click();
    }
    public void hobbies(){
        cricket.click();
        hockey.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0,800)");
    }
    public void languages(){
        languagesDropDown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(languageDutch)).click();
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click(bodyElement).build().perform();
    }
    public void skills(){
        skillsDropDown.click();
        Select skill=new Select(skillsDropDown);
        skill.selectByValue("Client Server");
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click(bodyElement).build().perform();
    }
    public void country(){
        countryDropDown.click();
    }
}