package saucelab.setup;

import com.microsoft.playwright.Page;

public class Cart {
	public static final String sub_header_xpath = "//div[@class ='subheader']";
	public static final String continueshopping_button_xpath = "Continue Shopping";
	public static final String checkout_button_xpath = "CHECKOUT";
	public static final String remove_button_xpath ="REMOVE";
	public static final String cart_xpath = "//a[contains(@class,'shopping_cart_link')]";
	public static final String finish_button_xpath = "FINISH";	
	private Page page;
	//CONSTRUCTON
	public Cart(Page page) {
		this.page = page;
	}
}
