package Pagepackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	WebDriver driver;
	@FindBy (id="email")
	WebElement emailid;
	@FindBy (id="enterimg")
	WebElement clickbutton;
	@FindBy (xpath="/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")
	WebElement firstname;
	@FindBy (xpath = "/html/body/section/div/div/div[2]/form/div[1]/div[2]/input")
	WebElement lastname;
	@FindBy (xpath = "//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")
	WebElement address;
	@FindBy (xpath = "/html/body/section/div/div/div[2]/form/div[3]/div[1]/input")
	WebElement emailaddress;
	@FindBy (xpath = "/html/body/section/div/div/div[2]/form/div[4]/div/input")
	WebElement phone;
	@FindBy (id="imagesrc")
	WebElement fileupload;
	@FindBy (xpath ="/html/body/section/div/div/div[2]/form/div[5]/div/label[2]/input")
	WebElement radiobutton;
	@FindBy (id="checkbox2")
	WebElement movies;
	@FindBy (id="firstpassword")
	WebElement firstpswd;
	@FindBy (id="secondpassword")
	WebElement secondpswd;
	@FindBy (id="submitbtn")
	WebElement submitbutton;
	@FindBy (xpath = "//*[@id=\"OKTab\"]/button")
	WebElement alertbutton;
public Loginpage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void loginmail(String mail)
{
	emailid.sendKeys(mail);
}
public void LoginClick()
{
    clickbutton.click();
}

public void EnterDetails(String fname,String lname,String ads,String email, String phonenum)
{
	firstname.sendKeys(fname);
	lastname.sendKeys(lname);
	address.sendKeys(ads);
	emailaddress.sendKeys(email);
	phone.sendKeys(phonenum);
}
public void fileUpload()
{
	fileupload.click();
}
public void radioclick()
{
	radiobutton.click();
}
public void movieClick()
{
	movies.click();
}
public void passwordSection(String fpwd, String spwd )
{
	firstpswd.sendKeys(fpwd);
	secondpswd.sendKeys(spwd);
}
public void Submit()
{
	submitbutton.click();
}
public void Alertpage()
{
	alertbutton.click();
}
}
