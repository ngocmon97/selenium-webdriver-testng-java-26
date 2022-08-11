package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_By {

//		- Bước 1: Mở browser lên
//		- Bước 2: Nhập vào Url
//		- Bước 3: Click vào My Account để mở trang login ra
//		- Bước 4: Click login
//		- Bước 5: Verify lỗi hiển thị
//		- Bước 6: Đóng browser
	// khao báo 1 biến đại diện cho thư viện Selenium WebDriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
  // 
	@BeforeClass
	public void beforeClass() {
//		- Bước 1: Mở browser lên
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// bấm cho maximize browser lên
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
//		- Bước 2: Nhập vào Url
		driver.get("https://www.facebook.com/");
		
//		- Bước 3: Click vào My Account để mở trang login ra		
	
//       tìm 1 element		
//		driver.findElement(null)
//      tìm 1 element	
//		driver.findElements(null)
		
	}

	@Test
	public void TC_02_() {
		
	}


	@AfterClass
	public void afterClass() {
//		- Bước 6: Đóng browser
		driver.quit();
	}
}
