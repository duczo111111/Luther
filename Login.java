package saucelab.setup;

import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.*;

public class Login{
	
	final private Page page;
	
	//3 objects to interact: USERNAME FIELD, PASSWORD FIELD, LOGIN BUTTON
	private static final String username_xpath = "//input[@placeholder='Username']";
	private static final  String password_xpath = "//input[@placeholder='Password']";
	private static final String loginbutton_xpath = "//input[@id = 'login-button']";
	
	//CONSTRUCTOR
	public Login(Page page){
	this.page = page;
	}
	
	//WEB ELEMENT
	private static final String webtitle_xpath = "//title[text()='Swag Labs']";
	private static final String weblogo_xpath = "//div[@class = 'login_logo']";
	private static final String webimg_xpath = "//img[@class='bot_column']";
	private static final String available_username_xpath = "//div[@class = 'login_credentials']";
	private static final String available_password_xpath = "//div[@class = 'login_password']";
	private static final String error_button_xpath = "//button[@class = 'error-button']";
	//ENTER VAlUE
	public void enterUsername(String username) {
		page.locator(username_xpath).fill(username);
	}
	public void enterPassword(String password) {
		page.locator(password_xpath).fill(password);
	}
	public void clickloginbutton() {
		page.locator(loginbutton_xpath).click();
	}
	
	//GET INPUT
	public String getUsername() {
		return page.locator(username_xpath).inputValue();
	}
	public String getPassword() {
		return page.locator(password_xpath).inputValue();
	}
	
	//CHECK LOGIN BUTTON, STRING IN USERNAME FIELD & PASSWORD FIELD
	public void isloginbuttonenabled() {
		Locator loginbutton = page.locator(loginbutton_xpath);
		boolean isloginbuttonenable = loginbutton.isEnabled();
		if (isloginbuttonenable) {
			System.out.println("Login button is enabled");
		} else {
			System.out.println("Login button is disabled");
		}
	}
	//CHECK STRING IN USERNAME FIEL
	public void username_string_display() {
		Locator username_inner_string = page.locator(username_xpath);
		String actual_string = username_inner_string.textContent();
		if ("Username".equals(actual_string)) {
			System.out.println("The string displayed is correct");
		} else {
			System.out.println("The string displayed is incorrect");
		}
	}
	//CHECKSTRING IN PASSWORD FIELD
	public void password_string_display() {
		Locator password_inner_string = page.locator(password_xpath);
		String actual_string = password_inner_string.textContent();
		if ("Password".equals(actual_string)) {
			System.out.println("The string displayed is correct");
		} else {
			System.out.println("The string displayed is incorrect");
		}
	}
}
  
	