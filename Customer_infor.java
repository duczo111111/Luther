package saucelab.setup;
import com.microsoft.playwright.*;

public class Customer_infor {
	public static String firstname_xpath = "//input[@id='first-name']";
	public static String lastname_xpath = "//input[@id='last-name']";
	public static String postalcode_xpath = "//input[@id='postal-code']";
	public static String cancel_button_xpath = "CANCEL";
	public static String continue_button_xpath = "//input[@value='CONTINUE']";
	private Page page;
	//CONSTRUCTON
	public Customer_infor(Page page) {
		this.page = page;
	}
}
