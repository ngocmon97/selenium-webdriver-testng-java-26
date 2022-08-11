package javaTester;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type {

	public static void main(String[] args) {
       // Thông tin của 1 nhân viên
		//Tên/ tuổi/ ngày tháng năm sinh/ giới tính/ quê quán/ lương
		
		//ánh xạ thông tin này vào lập trình/ phần mềm
		//Cách khai báo 1 biến
		//1. - kiểu dl cua biến
		//2. - tên biến
		//3. - giá trị của biến
		
		//Có 2 cách khai báo và gán giá trị
		//1. vừa khai báo vừa gán giá trị trực tiếp:
		//String name = "Automation Testing"
		//2. Khai báo trc và gán sau
		//VD: Stringname;
		//name = "Automation Testing"
		//name = "Automation FC"
		// có 2 loại kiểu dữ liệu
		
		//I. kiểu dữ liệu nguyên thủy (int/ long/ double (float)/ boolean)
		//gồm 8 loại:
		//Số nguyên: byte/ short/ int/ long :là những số k có phần thập phân
		byte bnumber = 250; //kiểu số nhỏ nhất đâu đó nằm trong khoảng 256 số
		short snumber = 500;		
		int inumber = 6000;
		long lnumber = 123456789; // hàng triệu
				//note: số và boolean không cần nháy đôi
		//số thực: float/ double (số dạng có thập phân)
		float salary =15.5f;
		double salary = 9.8d;
		
		//kí tự: char: dấu nháy đơn và chỉ chứa duy nhất 1 ký tự
		char s='s'
		//Logic: boolean (đại diện có tính chất đúng hoặc sai)
		
		
		
		//II. kiểu dữ liệu tham chiếu
		//Chuỗi: String (Vd: tên, số, ký tự đặc biệt) dùng dấu nháy đôi
		String emailInvalid = "afc@1452@$#%.gmail.com";
		
		//class/ Interface (date time)
		Date date = new Date();
		
		WebDriver driver = new FirefoxDriver();
		//Đối tượng: Object
		Object students;
		
		//Array: mảng - cố định  
		int numbers[] = {15, 20, 45};
		String addresses[] = {"Hà Nội", "HCM"};
		//List/ Set/ Queue (Conllection) - động
        
		List<Integer> studentNumber = new ArrayList<Integer>();
		List<String> studentNumber = new ArrayList<String>();
		
	}

}
