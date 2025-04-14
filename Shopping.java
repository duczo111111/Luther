package saucelab.setup;

import com.microsoft.playwright.*;

public class Shopping{
	//ADD TO CART, REMOVE, MENU, CART, SORT
	public static String addtocart_xpath, remove_xpath,itemname_xpath;
	public static final String menu_xpath = "//button[text()='Open Menu']";
	public static final String cart_xpath = "//a[contains(@class,'shopping_cart_link')]";
	public static final String sortmenu_xpath = "//select[@class = 'product_sort_container']";
	public static final String itemlist_xpath = "//div[@class = 'inventory_list']/div";
	public static final String sub_sortmenu_name_a_to_z_xpath = "//select[@class = 'product_sort_container']//option[@value = 'az']";
	public static final String sub_sortmenu_name_z_to_a_xpath = "//select[@class = 'product_sort_container']//option[@value = 'za']";
	public static final String sub_sortmenu_price_high_to_low_xpath = "//select[@class = 'product_sort_container']//option[@value = 'hilo']";
	public static final String sub_sortmenu_price_low_to_high_xpath = "//select[@class = 'product_sort_container']//option[@value = 'lohi']";
	private Page page;
	
	//CONSTRUCTOR
	public Shopping(Page page) {
		this.page = page;
	}
	
	//SET ITEM XPATH
	public void itemnumber(int itemnumber) {
		addtocart_xpath = "(//div[@class='inventory_list']//div[@class='inventory_item'])[" + itemnumber + "]//button";
		remove_xpath = "(//div[@class='inventory_list']//div[@class='inventory_item'])[" + itemnumber + "]//button";
	}
	public String itemname(int itemnumber) {
		return itemname_xpath = "//div[@class = 'inventory_item'][" + itemnumber + "]//div[@class='inventory_item_name']";
	}
}
