package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_Part1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
  // 
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("MAC")) {//MAC
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			} else { //Window
				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			}
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

	@Test
	public void Register_01_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

		//verify (actual data: drive...text= expected data: Vui ...ten)
		
		
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void Register_02_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action	
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Mon");
		driver.findElement(By.id("txtEmail")).sendKeys("3524652");
		driver.findElement(By.id("txtCEmail")).sendKeys("3524652");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0392371935");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//verify (actual data: drive...text= expected data: Vui ...ten)
		
		
	  
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		
		//bug
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

		
		
	}

	@Test
	public void Register_03_Incorrect_Email() {
    driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action	
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Mon");
		driver.findElement(By.id("txtEmail")).sendKeys("3524652@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("3524@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0392371935");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//verify (actual data: drive...text= expected data: Vui ...ten)
		
	
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

	}
	@Test
	public void Register_04_Password_Less_Than_6_Chars() {
		 driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			
			//action	
			
			driver.findElement(By.id("txtFirstname")).sendKeys("Mon");
			driver.findElement(By.id("txtEmail")).sendKeys("3524652@gmail.com");
			driver.findElement(By.id("txtCEmail")).sendKeys("3524652@gmail.com");
			driver.findElement(By.id("txtPassword")).sendKeys("1236");
			driver.findElement(By.id("txtCPassword")).sendKeys("1236");
			driver.findElement(By.id("txtPhone")).sendKeys("0392371935");
			driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
			
			//verify (actual data: drive...text= expected data: Vui ...ten)
			
			Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
			Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	@Test
	public void Register_05_Incorrect_Confirm_Password() {
		 driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			
			//action	
			
			driver.findElement(By.id("txtFirstname")).sendKeys("Mon");
			driver.findElement(By.id("txtEmail")).sendKeys("3524652@gmail.com");
			driver.findElement(By.id("txtCEmail")).sendKeys("3524652@gmail.com");
			driver.findElement(By.id("txtPassword")).sendKeys("123456");
			driver.findElement(By.id("txtCPassword")).sendKeys("123645");
			driver.findElement(By.id("txtPhone")).sendKeys("0392371935");
			driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
			
			//verify (actual data: drive...text= expected data: Vui ...ten)

			Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	@Test
	public void Register_06_Invalid__Phone_Number() {
		 driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			
			//action	
			
			driver.findElement(By.id("txtFirstname")).sendKeys("Mon");
			driver.findElement(By.id("txtEmail")).sendKeys("3524652@gmail.com");
			driver.findElement(By.id("txtCEmail")).sendKeys("3524652@gmail.com");
			driver.findElement(By.id("txtPassword")).sendKeys("123456");
			driver.findElement(By.id("txtCPassword")).sendKeys("123456");
			// < 10 so
			driver.findElement(By.id("txtPhone")).sendKeys("039235");
			driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
			Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
			
			// > 10 so
			driver.findElement(By.id("txtPhone")).clear();
			driver.findElement(By.id("txtPhone")).sendKeys("039237135246");
			driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
			Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
			
			// Start without 0 number
			driver.findElement(By.id("txtPhone")).clear();
			driver.findElement(By.id("txtPhone")).sendKeys("9876543210");
			driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
			Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
