package dao;

import java.util.ArrayList;
import java.util.Scanner;

import pojo.Product;

public class StoreInformation {

	// The instance fields of my class, a list of objects of the class Product, 
    ArrayList<Product> products;
    
    /*
     * This constructor public StoreInformation() is a parameterless constructor for a class named StoreInformation.
     */
	public StoreInformation() {
        /*
         * Initializes an ArrayList named products to store instances of the Product class. 
         * The this.products = new ArrayList<>(); line creates a new empty ArrayList.
         */
        this.products = new ArrayList<>();

        /*
         * Creates three instances of the Product class (p1, p2, p3) and sets their properties
         * (such as product ID, name, available quantity, category, buying price, and item name).
         */
        Product p1 = new Product();
        p1.setProductid(1);
        p1.setProductname("Mouse");
        p1.setAvailableQuantity(2);
        p1.setCategory("Computer");
        p1.setBuyingPrice(40000.0);
        p1.setItemName("Mouse");
        
        Product p2 = new Product();
        p2.setProductid(2);
        p2.setProductname("Laptop");
        p2.setAvailableQuantity(2);
        p2.setCategory("Computer");
        p2.setBuyingPrice(50000.0);
        p2.setItemName("Laptop");
        
        Product p3 = new Product();
        p3.setProductid(3);
        p3.setProductname("Book");
        p3.setAvailableQuantity(3);
        p3.setCategory("Stationery");
        p3.setBuyingPrice(300.0);
        p3.setItemName("Book");
        
        /*
         * Adds the three Product instances (p1, p2, p3) to the products 
         * ArrayList using the this.products.add(...); statements.
         */
        
        this.products.add(p1);
        this.products.add(p2);
        this.products.add(p3);
        
        /*
         * This constructor essentially initializes the products ArrayList with three initial 
         * Product objects containing predefined information. It's commonly used to set up initial 
         * data or state when an object of the StoreInformation class is created without any parameters.
         */
    }
	
	public void startApplication() {
        int option;
        do {
            displayMenu();
            System.out.println("Enter your choice (or enter 0 to exit): ");
            option = new Scanner(System.in).nextInt();
            
            if (option != 0) {
                switchOption(option);
            }
        } while (option != 0);
        
        System.out.println("Exiting the application.");
    }
    
    public void displayMenu() {
    	System.out.println("Please select one of the following options: ");
        System.out.println("1.	List the products in the store (productid, product Name, category, Quantity, price ) ");
        System.out.println("2.	Search the product by using productid ");
        System.out.println("3.	List the products by category (Grocery, Stationary, Toiletry, Vegetables) ");
        System.out.println("4.	Search the product by using the name and view the details of the product. ");
        System.out.println("5.	To check the total amount, spend on her products. ");
        System.out.println("6.	Display the Profit amount that she gets on category wise.  ");
        
    	
    }
    
    public void switchOption(int option) {
        switch (option) {
            case 1:
                displayAllProducts();
                
                break;
            case 2:
                System.out.println("Enter product ID to search: ");
                int productIdToSearch = new Scanner(System.in).nextInt();
                searchProductById(productIdToSearch);
                break;
            case 3:
                System.out.println("Enter category to list products: ");
                String categoryToSearch = new Scanner(System.in).next();
                searchProductByCategory(categoryToSearch);
                break;
            case 4:
                System.out.println("Enter product name to search: ");
                String productNameToSearch = new Scanner(System.in).next();
                searchProductByName(productNameToSearch);
                break;
            case 5:
            	totalAmountOnProduct();
                break;
            case 6:
            	System.out.println("Enter category");
            	String categoryprofit = new Scanner(System.in).next();
            	calculateProfit(categoryprofit);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
	
	public void displayAllProducts() {
		
	      System.out.println("Displaying All Products ");

	      for(int x = 0; x < this.products.size(); ++x) {
	         System.out.println("Product name is " + this.products.get(x).getProductname());
	         System.out.println("Product Quantity is " + this.products.get(x).getAvailableQuantity());
	         System.out.println("Buying price is " + this.products.get(x).getBuyingPrice());
	      }

	   }
	
	public void searchProductById(int prodid) {
	    for (int count = 0; count < this.products.size(); ++count) {
	        if (this.products.get(count).getProductid() == prodid) {
	            System.out.println("Product name by id " + this.products.get(count).getProductname());
	            System.out.println("Product Category by id " + this.products.get(count).getCategory());
	            break; // Added break statement to exit the loop after finding the first occurrence
	        }
	    }
	}
	
	public int searchProductByCategory(String categor) {
	    int searchLength = 0;

	    for (int count = 0; count < this.products.size(); ++count) {
	        if (this.products.get(count).getCategory().equals(categor)) {
	            System.out.println("Product name by category: " + this.products.get(count).getProductname());
	            System.out.println("Product Category: " + this.products.get(count).getCategory());
	            System.out.println("Buying Price: " + this.products.get(count).getBuyingPrice());
	            ++searchLength;
	        }
	    }

	    return searchLength;
	}
	
	
	public void searchProductByName(String name) {
	    for (int count = 0; count < this.products.size(); ++count) {
	        if (this.products.get(count).getProductname().equals(name)) {
	            System.out.println("Product name: " + this.products.get(count).getProductname());
	            System.out.println("Product Category: " + this.products.get(count).getCategory());
	            System.out.println("Buying Price: " + this.products.get(count).getBuyingPrice());
	            
	            break;
	        }
	    }
	}
	
	public void totalAmountOnProduct() {
	    double totalAmount = 0.0;

	    for (int x = 0; x < this.products.size(); ++x) {
	        if (this.products.get(x).getBuyingPrice() != 0.0) {
	            totalAmount += this.products.get(x).getBuyingPrice();
	        }
	    }

	    System.out.println("Total Amount Spent On Products: " + totalAmount);
	}

	
	
	public void calculateProfit(String category) {
	    double totalProfit = 0.0;

	    for (int x = 0; x < this.products.size(); ++x) {
	        if (this.products.get(x).getCategory().equals(category)) {
	            double profit = this.products.get(x).getSellingPrice() - this.products.get(x).getBuyingPrice();
	            totalProfit += profit;
	        }
	    }

	    System.out.println("Total Profit for Category " + category + ": " + totalProfit);
	}


	
	
}
