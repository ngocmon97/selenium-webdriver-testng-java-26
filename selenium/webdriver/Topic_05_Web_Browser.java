package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
	//Khai báo
	WebDriver driver;
	WebElement element;
	//khai báo + khởi tạo (dấu hiệu nhận biết có bằng)
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("MAC")) {//MAC
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else { //Window
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		//Khởi tạo (Cứ new là khởi tạo)
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	 

	@Test
	public void TC_01_() {
	// Các hàm tương tác với browser qua các biến driver
	// Đóng browres (1tab - tab đang đứng)
	driver.close();
	// Đóng browres (tất cả các tab)	
	driver.quit();
	// tìm element
	WebElement loginButton = driver.findElement(By.cssSelector(null));
	List<WebElement> links driver.findElements(null);
	//tìm mở ra url truyền vào
	driver.get(osName);
	// tìm trả về 1 url tại tab đang đứng
	String gamePageUrl = driver.getCurrentUrl();
	
	
	//note: action (VD:close/ quit/ refresh/ back/ forward/ click/ select/ sendkey/......) - void
	//      verify (lấy dl ra url,text, thuộc tính,...) -get
	
	//Source code của page hiện tại
	String gamePageSourceCode = driver.getPageSource();	
	// ex: Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
	
	// lấy ra ID của tab/windown đang đứng/ active (windown/tab)
	driver.getWindowHandle(); //1
	driver.getWindowHandles(); // tất cả
	
	driver.manage().getCookies();// cookies
	driver.manage().logs().getAvailableLogTypes();// log
	driver.manage().window().fullscreen();
	driver.manage().window().maximize();
	
	//chờ cho element đc tìm thấy trong khoảng x giây (webdriverwait)
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	//chờ cho element load trong khoảng x giây
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS)	;
	//chờ cho script đc chạy thành công vào browser/elemet sau khoảng x giây (javascrptExecutor)
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS)	;
	
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to(null););
		
	//Alert/frame/windown/tab
		driver.switchTo().alert();
		driver.switchTo().frame(0);
		driver.switchTo().window(gamePageSourceCode);
		
	
	}

	@Test
	public void TC_02_() {
		driver.get("");
	// Các hàm tương tác với Element qua các biến element
	// 2 cách để mình thao tác:
		//khai báo biến và dùng lại - ít nhất 2 lần mới cần khai báo biến (khai báo biến với cùng kiểu dl trả về của hàng findElement (đang gán emailAddressTextbox thành 1 cái câu lệnh như kiểu gán A cho ptrinh x+y)
		WebElement emailAddressTextbox = driver.findElement(By.id("email"));
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys("ngoc@gmail.com");
		//dùng trực tiếp - 1 lần dùng
		driver.findElement(By.id("email")).sendKeys("ngoc@gmail.com");
		driver.get("https://www.facebook.com/");
		// Các hàm tương tác vs Element sẽ thông qua cái class WebElement (biến nào đó)

		// Xóa dữ liệu trong 1 field dạng editable (có thể nhập)
		// Textbox/ Text Area/ Editable Dropdown
		element.clear();

		// Nhập dữ liệu vào field dạng editable
		element.sendKeys("dam@gmail.com");
		element.sendKeys(Keys.ENTER);
		
		// Click vào những element: Button/ Link/ Checkbox/ Radio/ Image/...
		element.click();

		// Trả về giá trị nằm trong cái attribute của element
		element.getAttribute("placeholder");
		// Email address or phone number

		driver.findElement(By.id("firstname")).getAttribute("value");

		// Trả về thuộc tính Css của element này
		// Font/ size/ color

		// Trả về màu nền của element
		element.getCssValue("background-color");

		// Trả về font size của element
		element.getCssValue("font-size");

		// Test GUI: Point/ Rectangle/ Size (Visualize Testing)
		element.getLocation();
		element.getRect();
		element.getSize();

		// Chụp hình và attach vào HTML Report
		element.getScreenshotAs(OutputType.FILE);

		// Trả về thẻ HTML của element
		WebElement emailAddressTextbox = driver.findElement(By.xpath("//*[@id='email']"));
		emailAddressTextbox = driver.findElement(By.cssSelector("#email"));
		emailAddressTextbox.getTagName();
		// input

		// Trả về text của 1 element (Link/ Header/ Message lỗi/ Message success/..)
		element.getText();

		// Trả về giá trị đúng hoặc sau của 1 element có hiển thị hoặc ko
		element.isDisplayed();
		// Hiển thị: true
		// Ko hiển thị: false

		// Trả về giá trị đúng hoặc sau của 1 element có thể thao tác được hay ko
		// Có bị disabled ko
		element.isEnabled();
		// Enabled: true
		// Bị disabled: false

		// Trả về giá trị đúng hoặc sai của 1 element đã được chọn rồi hay chưa
		// Checkbox/ Radio
		element.isSelected();
		// Chọn ra: true
		// Chưa chọn: false
		
		// Dropdown: có 1 thư viện riêng để xử lí (Select)
		
		// Chỉ làm việc được với form (register/ login/ search/..)
		// Submit = ENTER ở 1 field nào đó
		// Submit vào 1 field nào đó trong form
		element.submit();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

	}
	
	@Test
	
	


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
