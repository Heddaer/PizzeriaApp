/*
 *  Namn: Hedda Eriksson
 *  Dator-id: 9098
 *  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
 *  Datum: 12/12 - 2021
 * */
package Model;

public class Pizza extends Food  {

    private String toppings;

    public Pizza(String productName, double productPrice, String toppings) {
        super(productName, productPrice);
        this.toppings = toppings;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    @Override
    public String getProductName() {
        return super.getProductName();
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public double getProductPrice() {
        return super.getProductPrice();
    }

    @Override
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    @Override
    public void setProductType(ProductType productType) {
        this.productType = ProductType.Pizza;
    }

    public String toString(){
        return String.format("%s - %2s  | á %1.2f:-", productName, toppings, productPrice);
    }

    public String toStringHistory(){
        return String.format("%s | á %1.2f:-", productName, productPrice);
    }

}
