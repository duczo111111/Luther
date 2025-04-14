package saucelab;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucelab.setup.Launcher;
import saucelab.setup.Login;
import saucelab.setup.Shopping;
import saucelab.setup.Cart;
import saucelab.setup.Customer_infor;

import java.util.ArrayList;
import java.util.List;

public class Stepdefinition {
	Launcher launcherobj = new Launcher();
	Page pageobj = launcherobj.getpage();
	
	Login loginobj = new Login(pageobj);
	Shopping shoppingobj = new Shopping(pageobj);
	Cart cartobj = new Cart(pageobj);
	Customer_infor inforobj = new Customer_infor(pageobj);
	@Given("User visit page")
	public void user_visit_page() {
		pageobj.navigate("https://www.saucedemo.com/v1/");
	
	}

	@When("User login with {string} and {string}")
	public void user_login_with_username_and_password(String username, String password) {
		try {
			Thread.sleep(1000);
			loginobj.username_string_display();
			loginobj.enterUsername(username);
			loginobj.getUsername();
			loginobj.password_string_display();
			loginobj.enterPassword(password);
			loginobj.getPassword();
			loginobj.isloginbuttonenabled();
		} catch (InterruptedException e) {}
	
	}

	@Then ("User is navigated to shoppingpage")
	public void user_navigated_to_shopingpage() {
		try {
			Thread.sleep(1000);
			loginobj.clickloginbutton();
		} catch (InterruptedException e) {}
	}

	@When ("User pick second, third, fifth and sixth item")
	public void user_pick_second_third_fifth_and_sixth_item() {
		try {
			Thread.sleep(1000);
			shoppingobj.itemnumber(2);
			pageobj.click(Shopping.addtocart_xpath);
			Thread.sleep(1000);
			shoppingobj.itemnumber(3);
			pageobj.click(Shopping.addtocart_xpath);
			Thread.sleep(1000);
			shoppingobj.itemnumber(5);
			pageobj.click(Shopping.addtocart_xpath);
			Thread.sleep(1000);
			shoppingobj.itemnumber(6);
			pageobj.click(Shopping.addtocart_xpath);
			
		} catch (InterruptedException e) {}
	}
	
	@And ("User remove third and sixth item")
	public void user_remove_third_and_sixth_item() {
		try {
			Thread.sleep(1000);
			shoppingobj.itemnumber(3);
			pageobj.click(Shopping.remove_xpath);
			Thread.sleep(1000);
			shoppingobj.itemnumber(6);
		} catch (InterruptedException e) {}
	}
	
	@And("User sort item from high price")
	public void user_sort_item_from_high_price() {
		List<String> list_itemname_before = new ArrayList<>();
		List<String> list_itemname_after = new ArrayList<>();
		
		for (int i = 1;i<=6;i++) {
			String itemname = pageobj.locator(shoppingobj.itemname(i)).textContent();
			list_itemname_before.add(itemname);
		}
		System.out.println("Inventory list before sorted:" + list_itemname_before);
		pageobj.locator(Shopping.sortmenu_xpath).selectOption("hilo");
		for (int i = 1;i<=6;i++) {
			String itemname = pageobj.locator(shoppingobj.itemname(i)).textContent();
			list_itemname_after.add(itemname);
		}
		System.out.println("Inventory list after sorted" + list_itemname_after);
	}
	@When("User click checkout")
	public void user_click_checkout() {
		pageobj.click(Shopping.cart_xpath);
	}

	@Then("User navigated to checkout page")
	public void user_navigated_to_checkout_page() {
		String sub_header = pageobj.innerText(Cart.sub_header_xpath);
		if (sub_header.equals("Your Cart")) {
			System.out.println("Customer is at the CART PAGE");
			System.out.println(sub_header);
		} else {
			System.out.println("ERORR");
			System.out.println(sub_header);
		}
	}

	@When("User enter information and click continue")
	public void user_enter_information() {
		pageobj.getByText(Cart.checkout_button_xpath).click();
		pageobj.locator(Customer_infor.firstname_xpath).fill("Luther");
		pageobj.locator(Customer_infor.lastname_xpath).fill("Tran");
		pageobj.fill(Customer_infor.postalcode_xpath, "23124123");
		pageobj.locator(Customer_infor.firstname_xpath).innerText();
		pageobj.locator(Customer_infor.lastname_xpath).innerText();
		pageobj.locator(Customer_infor.postalcode_xpath).innerText();
		pageobj.click(Customer_infor.continue_button_xpath);
	}

	@And("User click finish")
	public void user_click_finish() {
		pageobj.getByText(Cart.finish_button_xpath).click();
	}

	@Then("User navigated to result page")
	public void user_navigated_to_result_page() {
		pageobj.locator("//div[@class='subheader']").innerText();
		pageobj.close();	
	}
}
