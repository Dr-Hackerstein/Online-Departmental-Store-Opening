package pojo;

public class Item {
   protected String itemName;
   protected String category;
   protected double buyingPrice;
   
   // The constructor has no data
   public Item() {
   }
   
   public String getItemName() {
      return this.itemName;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   public String getCategory() {
      return this.category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public double getBuyingPrice() {
      return this.buyingPrice;
   }

   public void setBuyingPrice(double buyingPrice) {
      this.buyingPrice = buyingPrice;
   }


}