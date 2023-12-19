/*
*  Namn: Hedda Eriksson
*  Dator-id: 9098
*  Utbildning: Datateknik och Mobil IT: Högskoleingenjörsprogrammet
*  Datum: 12/12 - 2021
* */

package Model;

public abstract class Food implements IProducts {

    protected String productName;
    protected double productPrice;
    protected ProductType productType;

    public Food(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

   public String getProductName() {
        return productName;
    }

    public abstract void setProductName(String productName);

    public double getProductPrice() {
        return productPrice;
    }

    public abstract void setProductPrice(double productPrice);

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public abstract void setProductType(ProductType productType);
}
