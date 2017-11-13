
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CreateNewEvent extends BaseTest{

	CreateNewEvent(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//md-select[@name='requesterRole']")
	WebElement role;
	
	
    public void selectRandomRole(){
		Random r=new Random();
		r.nextInt();
		Select randomRole=new Select(role);
		randomRole.selectByIndex(r.nextInt(2));
	}
    
	public void fillRequestDetails(){
	          	selectRandomRole();
	}
}
